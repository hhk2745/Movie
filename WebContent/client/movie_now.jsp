<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../top.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/modal.css">
<c:if test="${not empty msg}">
	<script type="text/javascript">
		alert("${msg}");
		location.href = "member_Login.do";
	</script>
</c:if>
<div class="col-xs-12" style="padding-top: 3rem">
   <table align="center">
      <tr>
         <td align="center">
            <button type="button" class="btn btn-default">
               <a href="client_movie_all.do" style="font-size: 3rem;">
               <img src="img\theater\btn_all.png"><!-- 모든 영화 --></a>
            </button>
            <button class="btn btn-primary" style="border: 5px solid lightgray;">
               <a href="client_movie_now.do" style="font-size: 3rem;">
               <img src="img\theater\btn_nowmovie.png"><!-- 현재개봉작 --></a>
            </button>
            <button class="btn btn-success">
               <a href="client_movie_box.do" style="font-size: 3rem;">
               <img src="img\theater\btn_boxoffice.png"><!-- 박스오피스 --></a>
            </button>
            <button class="btn btn-info">
               <a href="client_movie_due.do" style="font-size: 3rem;">
               <img src="img\theater\btn_comingmovie.png"><!-- 개봉 예정작 --></a>
            </button>

         </td>
      </tr>
   </table>
</div>
<div style="padding-top: 3rem">.</div>
<main>

   <div class="row">
      <c:forEach var="dtoList" items="${nowmovieList}">

         <div class="col-sm-4 col-lg-4 col-md-4">
            <div class="thumbnail">
               <img src="${pageContext.request.contextPath}/poster/${dtoList.file_directory}/${dtoList.poster}" width="300px">
               <div class="caption">
                  <h4 class="pull-right">${dtoList.runtime } &nbsp; (분)</h4>
                  <h4 class="movie-title">
                     <button type="button" class="btn btn-default btn-lg"
                        data-toggle="modal" data-target="#${dtoList.num }" data-title="num"
                        onclick="<c:set var='num' value='${dtoList.num }'/>"><font style="font-size:15px;font-weight: bold"> ${dtoList.title}</font></button>

                  </h4>
               </div>
               
            </div>
         </div>
         <!-- 영화 상세정보 모달 팝업 -->
   <div class="modal fade" id="${dtoList.num }" tabindex="-1" role="dialog"
      aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">×</span><span class="sr-only">Close</span>
               </button>
               <h4 class="modal-title" id="myModalLabel">영화 상세정보</h4>
            </div>
            <div class="modal-body">
            
               
               <c:forEach var="dto" items="${nowmovieList}">
                      <c:if test="${dto.num == num}">
                     <table border="0" align="center">
                     <tr>
                        <td align="center">
							<img src="${pageContext.request.contextPath}/poster/${dtoList.file_directory}/${dtoList.poster}" width="300px">
						</td>
                     </tr>
                  </table>
                  <hr color="Gray" width="99%">
								<div style="padding: 10px">
									<br> 영화 제목
									<pre>${dto.title}</pre>
									<p>개봉일
									<pre>${dto.opendate} </pre>
									<p>감독
									<pre>${dto.director} </pre>
									<p>출연진
									<pre>${dto.actor}	</pre>
									<p>장르
									<pre>${dto.genre}</pre>
									<p>누적관객
									<pre>${dto.watchcount}</pre>
									<p>
										<font color="tomato">상영시간 </font>
									<pre>${dto.runtime}</pre>
									<p>줄거리
									<pre id="movie_content">${dto.movie_info}	</pre>
									<p>
								</div>

								<div class="modal-footer">

                           <button type="button" class="btn btn-default"
                              data-dismiss="modal"
                              onclick="location.href='client_theaterReserve.do?num=${dto.num }'">예매하기</button>

                        </div>
                     한줄평 : <form action="admin_movie_insertReply.do" name="f"
                           method="post">
                           <input type="hidden" name="surl"
                              value="${pageContext.request.requestURL}"> <input
                              type="hidden" name="movieNum" value="${dto.num}"> <input
                              type="hidden" name="id" value="${loginId.id}">
                           <table border="center" width="99%">
                              <tr>
                                 <td><input type="text" name="reply" size="62"></td>
                                 <td align="right" bgcolor="#ffdab9"><input type="submit"
                                    value="등록"> <input type="reset" value="취소"></td>
                              </tr>
                           </table>
                           <br>
                           <hr color="Gray" width="99%">
                           <br>
                           <!-- @@@@@@@@@ -->
                           <c:set var="pageSize" value="3"/>
                           <c:set var="currnetPage" value="${pageNum}"/>
                           <c:set var="startRow" value="${pageSize*(currentPage)-1}"/>
                           <c:set var="endRow" value="${startRow+pageSize-1}"/>
                           <c:set var="count" value="0"/>
                           <c:forEach var="countdto" items="${allReplyList}">
                               <c:if test="${countdto.movieNum == num}">
                               <c:set var="count" value="${count+1}"/>
                               </c:if>
                           </c:forEach>
                           <!-- @@@@@@@@@ -->
                           <table border="1" align="center">
                           		<tr>	
                           			<th width="15%">ID</th>
                           			<th width="60%">한줄평</th>
                           			<th width="15%">날짜</th>
                           			<th width="10%"></th>
                           		</tr>
                           <c:choose>
                           		<c:when test="${empty allReplyList}">
                           			<tr>
                           				<td colspan="4">등록된 한줄평이 없습니다.</td>
                           			</tr>
                           		</c:when>
                           		<c:otherwise>
                           		<c:set var="rowCount" value="0"/>
		                           <c:forEach var="replydto" items="${allReplyList}">
		                                 <c:if test="${replydto.movieNum == num}">
		                                    <!-- <div>-->
		                                        <tr>
		                                           <td align="center" width="15%">${replydto.id}</td>
		                                           <td align="center" width="60%">${replydto.reply}</td>
		                                           <td align="center" width="15%">${replydto.reg_date}</td>
		                                           <!--같은 로그인 아이디일때만 삭제버튼  admin일때 다 만들어야함.-->
		                                           <c:if test="${loginId.id == replydto.id}">
		                                              <td align="center" width="10%">
		                                              <input type="button" name="delete" value="삭제" onclick="location.href='admin_movie_replyDelete.do?num=${replydto.num}&mode=now'"></td>
		                                           </c:if>
		                                           <c:if test="${loginId.id != replydto.id}">
		                                              <td align="center" width="10%"></td>
		                                           </c:if>
		                                        </tr>
		                                        <c:set var="rowCount" value="${rowCount+1}"/>
		                                 </c:if>
		                            </c:forEach>
                           		</c:otherwise>
                           </c:choose>
                            </table>
                        </form>
                     </c:if>
               </c:forEach>
            </div>
         </div>
      </div>
   </div>
      </c:forEach>
   </div>

</div>
<div class="container">

   <!-- 버튼 -->

   

   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script
      src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   <script src="http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg"></script>
   <!-- ie10-viewport-bug-workaround.js -->
   <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>
   <!-- holder.js -->
</main>


<%@ include file="../bottom.jsp"%>