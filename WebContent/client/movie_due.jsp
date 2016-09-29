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
               <a href="client_movie_all.do" style="font-size: 3rem;">모든 영화</a>
            </button>
            <button class="btn btn-primary">
               <a href="client_movie_now.do" style="font-size: 3rem;">현재개봉작</a>
            </button>
            <button class="btn btn-success">
               <a href="client_movie_box.do" style="font-size: 3rem;">박스오피스</a>
            </button>
            <button class="btn btn-info">
               <a href="client_movie_due.do" style="font-size: 3rem;">개봉 예정작</a>
            </button>

         </td>
      </tr>
   </table>
</div>
<div style="padding-top: 3rem">.</div>
<main>
   <div class="row">
      <c:forEach var="dtoList" items="${duemovieList}">

         <div class="col-sm-4 col-lg-4 col-md-4">
            <div class="thumbnail">
               <img src="${pageContext.request.contextPath}/poster/${dtoList.file_directory}/${dtoList.poster}" width="99%">
               <div class="caption">
                  <h4 class="pull-right">10,000원</h4>
                  <h4 class="movie-title">
                     <button type="button" class="btn btn-primary btn-lg"
                        data-toggle="modal" data-target="#${dtoList.num }" data-title="num"
                        onclick="<c:set var='num' value='${dtoList.num }'/>">${dtoList.title}</button>
                     
               

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
               
               
               <c:forEach var="dto" items="${duemovieList}">
                  <c:if test="${dto.num == num}">
                  <table border="0" align="center">
                     <tr>
                        <td align="center"><img src="${pageContext.request.contextPath}/poster/${dtoList.file_directory}/${dtoList.poster}" width="99%"></td>
                     </tr>
                  </table>
                     <table border="0">
                        <tr>
                           <td width="100px">개봉일:</td>
                           <td>${dto.opendate}</td>
                        </tr>
                        <tr>
                           <td width="100px">영화 제목:</td>
                           <td>${dto.title}</td>
                        </tr>
                        <tr>
                           <td width="17.5%">감독:</td>
                           <td>${dto.director}</td>
                        </tr>
                        <tr>
                           <td width="17.5%">출연진:</td>
                           <td>${dto.actor}</td>
                        </tr>
                        <tr>
                           <td width="17.5%">장르:</td>
                           <td>${dto.genre}</td>
                        </tr>
                        <tr>
                           <td width="17.5%">누적관객:</td>
                           <td>${dto.watchcount}</td>
                        </tr>
                        <tr>
                           <td width="17.5%"><font color="tomato">상영시간: </font></td>
                           <td>${dto.runtime}</td>
                        </tr>
                        <tr>
                           <td width="17.5%">줄거리</td>
                           <td>${dto.movie_info}</td>
                        </tr>

                     </table>
                     <div class="modal-footer">

                        <button type="button" class="btn btn-default"
                           data-dismiss="modal"
                           onclick="location.href='client_theaterReserve.do?num=${dto.num }'">예매하기</button>

                     </div>
                     한줄평 : <form action="admin_movie_insertReply.do" name="f"
                           method="post">
                           <input type="hidden" name="surl" value="${pageContext.request.requestURL}">
                           <input type="hidden" name="movieNum" value="${dto.num}">
                           <input type="hidden" name="id" value="${loginId.id}">
                           <table border="center" width="99%">
                              <tr>
                              
                                 <td ><input type="text" name="reply" size="62"></td>
                                 <td align="right" bgcolor="#ffdab9">
                                 <input type="submit" value="등록"> <input type="reset" value="취소"></td>
                                 
                              </tr>
                           <c:forEach var="replydto" items="${allReplyList}">
                                 <c:if test="${replydto.movieNum == num}">
                                 <div>
                                 
                                 </div>
                               <div>
                                  <table border="1" align="center">
                                     <tr>
                                       <td align="center" width="15%px">아이디: ${replydto.id}</td>
                                       <td align="center" width="60%">${replydto.reply}</td>
                                       <td align="center" width="15%">${replydto.reg_date}</td>
                                       <!--같은 로그인 아이디일때만 삭제버튼  -->
                                       <c:if test="${loginId.id == replydto.id}">
                                          <td align="center" width="10%%"><input type="button" name="delete" value="삭제" onclick="location.href='admin_movie_replyDelete.do?num=${replydto.num}'"></td>
                                       </c:if>
                                    </tr>
                                 </table>
                              </div> 
                              </c:if>
                              </c:forEach> 
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