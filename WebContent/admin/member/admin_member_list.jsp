<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- adamin_member.jsp -->
<%@ include file="../admin_top.jsp"%>
<div align="center">
	<ul class="submenuBox">
		<a href="admin_member.do">
			<li class="subHover effect"><span>회원리스트</span></li>
		</a>
		<!-- <a>
			<li class="subHover effect"><span>+</span></li>
		</a> -->
	</ul>
	<hr color="Green" width="99%">
	<h2>회원리스트</h2>
	<hr color="Green" width="99%">
	<table border="1" width="99%">
		<tr bgcolor="#ffdab9">
			<th align="center">번호</th>
			<th align="center">이름</th>
			<th align="center">ID</th>
			<th align="center">Email</th>
			<th align="center">Money</th>
			<th align="center">Point</th>
			<th align="center">비고</th>
		</tr>

		<c:if test="${empty list}">
			<tr>
				<td colspan="7">등록된 회원이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${!empty list}">
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.num }</td>
					<td>${dto.name }</td>
					<td>${dto.id }</td>
					<td>${dto.email }</td>
					<td>${dto.money }</td>
					<td>${dto.point }</td>
					<td><a href="admin_member_update.do?num=${dto.num}">수정</a> | <a href="admin_member_delete.do?num=${dto.num}">삭제</a></td>
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

		<fmt:parseNumber var="endPage" value="${startPage+pageBlock-1}"
			integerOnly="true" />
		<!--  -->
		<c:if test="${endPage>pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>
		<c:if test="${startPage>pageBlock}">
		[<a href="admin_member.do?pageNum=${startPage-pageBlock}">이전</a>]
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${i<10}">
				<a href="admin_member.do?pageNum=${i}"> ${i } </a>&nbsp;&nbsp;&nbsp;
			</c:if>


			<c:if test="${i>=10}">
				[<a href="admin_member.do?pageNum=${i}">${i}</a>]
			</c:if>
		</c:forEach>

		<%--  <fmt:parseNumber var="var3" value="${var1/var2}" integerOnly="true" /> --%>
		<c:if test="${endPage<pageCount}">
				[<a href="admin_member.do?pageNum=${startPage+pageBlock}">다음</a>]
			</c:if>

	</c:if>


</div>

<%@ include file="../admin_bottom.jsp"%>