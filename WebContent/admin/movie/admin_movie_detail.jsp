<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- admin_moive_detail.jsp -->
<%@ include file = "../admin_top.jsp"%>
<div align="center">
	<ul class="submenuBox">
		<a href="admin_movie.do">
			<li class="subHover effect">
				<span>영화리스트</span>
			</li>
		</a>
		<a href="admin_movie_insert.do">
			<li class="subHover effect">
				<span>영화추가</span>
			</li>
		</a>
		<!-- <a>
			<li class="subHover effect">
				<span>+</span>
			</li>
		</a> -->
	</ul>
	<hr color="Green" width="99%">
	<h2>영화상세보기</h2>
	<hr color="Green" width="99%">
	<img src="${pageContext.request.contextPath}/poster/${movieDTO.file_directory}/${movieDTO.poster}" width="300px">
	<table border="center" width="99%">
		<tr>
			<td align="center" width="15%" bgcolor="#ffdab9">제목</td>
			<td align="center" width="50%">${movieDTO.title}</td>
			<td align="center" width="15%" bgcolor="#ffdab9">Like</td>
			<td align="center" width="20%">${movieDTO.like_num}</td>
		</tr>
		<tr>
			<td align="center" width="15%" bgcolor="#ffdab9">국가</td>
			<td align="center" width="50%">${movieDTO.country}</td>
			<td align="center" width="15%" bgcolor="#ffdab9">제한연령</td>
			<td align="center" width="20%">${movieDTO.grade}</td>
		</tr>
		<tr>
			<td align="center" width="15%" bgcolor="#ffdab9">개봉일</td>
			<td align="center" width="50%">${movieDTO.opendate}</td>
			<td align="center" width="15%" bgcolor="#ffdab9">상영시간</td>
			<td align="center" width="20%">${movieDTO.runtime}</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#ffdab9">장르</td>
			<td align="center" colspan="3">${movieDTO.genre}</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#ffdab9">영화감독</td>
			<td align="center" colspan="3">${movieDTO.director}</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#ffdab9">영화배우</td>
			<td align="center" colspan="3">${movieDTO.actor}</td>
		</tr>
		<tr height="50%">
			<td align="center" bgcolor="#ffdab9">영화정보</td>
			<td align="center" colspan="3">${movieDTO.movie_info}</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#ffdab9">포스터</td>
			<td align="center" colspan="3">${movieDTO.poster}</td>
		</tr>
		<tr>
			<td align="right" colspan="4" bgcolor="#ffdab9">
				<c:if test="${compare<0}"><input type="button" value="스케줄링" onclick="window.location='admin_movie_closeDate.do?num=${movieDTO.num}'"></c:if>
				<input type="button" value="영화수정" onclick="window.location='admin_movie_update.do?num=${movieDTO.num}'">
				<input type="button" value="영화삭제" onclick="window.location='admin_movie_delete.do?num=${movieDTO.num}'">
			</td>
		</tr>
	</table>
	<br>
	<hr color="Gray" width="99%">
	<hr color="Gray" width="99%">
	<h2>영화 한줄평</h2>
	
	<br>
	<table border="1" width="99%">
		<tr bgcolor="#ffdab9">
			<th align="center">번호</th>
			<th align="center">I D</th>
			<th align="center">내 용</th>
			<th align="center">날짜</th>
			<th align="center">삭제</th>
		</tr>
			<c:choose>
				<c:when test="${endRow>count}">
					<c:set var="endRow" value="${count}"/>
						<c:if test="${empty replyList}">
							<tr>
								<td colspan="5">등록된 글이 없습니다.</td>
							</tr>
						</c:if>
				</c:when>
			</c:choose>
			<!-- @@@@@ -->
			<c:forEach var="dto" items="${replyList}">
				<tr>
					<td>${dto.rn}</td>
					<td>${dto.id}</td>
					<td>${dto.reply}</td>
					<td>${dto.reg_date}</td>
					<td>
						<a href="admin_movie_replyDelete.do?num=${dto.num}&movieNum=${movieDTO.num}&mode=admin">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<c:if test="${empty count}">
		<c:set var="count" value="0" />
	</c:if>
	<c:if test="${!empty count}">
		<c:set var="count" value="${count}" />
	</c:if>
	<c:if test="${empty currentPage}">
		<c:set var="currentPage" value="1" />
	</c:if>
	<c:if test="${!empty currentPage}">
		<c:set var="currentPage" value="${currentPage}" />
	</c:if>
	<c:if test="${empty pageSize}">
		<c:set var="pageSize" value="3" />
	</c:if>
	<c:if test="${!empty pageSize}">
		<c:set var="pageSize" value="${pageSize}" />
	</c:if>
	
	<c:if test="${count>0}">

		<fmt:parseNumber var="endPage" value="${startPage+pageBlock-1}" integerOnly="true" />
		<!--  -->
		<c:if test="${endPage>pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>
		<c:if test="${startPage>pageBlock}">
		[<a href="list.board?pageNum=${startPage-pageBlock}">이전</a>]
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${i<10}">
				<a href="admin_movie.do?pageNum=${i}"> 
					${i }
				</a>&nbsp;&nbsp;&nbsp;
			</c:if>


			<c:if test="${i>=10}">
				[<a href="admin_movie.do?pageNum=${i}">${i}</a>]
			</c:if>
		</c:forEach>

		<%--  <fmt:parseNumber var="var3" value="${var1/var2}" integerOnly="true" /> --%>
		<c:if test="${endPage<pageCount}">
				[<a href="admin_movie.do?pageNum=${startPage+pageBlock}">다음</a>]
		</c:if>

	</c:if>
</div>
<%@ include file = "../admin_bottom.jsp"%>