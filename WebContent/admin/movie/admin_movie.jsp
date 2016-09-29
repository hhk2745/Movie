<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- admin_moive.jsp -->
<%@ include file="../admin_top.jsp"%>
<div align="center">
	<ul class="submenuBox">
		<a href="admin_movie.do">
			<li class="subHover effect"><span>영화리스트</span></li>
		</a>
		<a href="admin_movie_insert.do">
			<li class="subHover effect"><span>영화추가</span></li>
		</a>
		<!-- <a>
			<li class="subHover effect"><span>+</span></li>
		</a> -->
	</ul>
	<hr color="Green" width="99%">
	<h2>영화리스트</h2>
	<hr color="Green" width="99%">
	<table border="1" width="99%">
		<tr bgcolor="#ffdab9">
			<th align="center">번호</th>
			<th align="center">제목</th>
			<th align="center">장르</th>
			<th align="center">등급</th>
			<th align="center">국가</th>
			<th align="center">개봉일</th>
			<th align="center">비고</th>
		</tr>
		
		<c:if test="${empty list}">
			<tr>
				<td colspan="7">등록된 영화가 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${!empty list}">
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.num }</td>
					<td><a href="admin_movie_detail.do?num=${dto.num}">${dto.title }</a></td>
					<td>${dto.genre }</td>
					<td>${dto.grade }</td>
					<td>${dto.country }</td>
					<td>${dto.opendate }</td>
					<td><a href="admin_movie_update.do?num=${dto.num }">수정</a></td>
				</tr>
			</c:forEach>
		</c:if>
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

<%@ include file="../admin_bottom.jsp"%>