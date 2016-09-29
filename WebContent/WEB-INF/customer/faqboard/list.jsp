<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="../../../top.jsp"%>

<section class="content">
	<nav>
		<ul>
			<li><a href="customer_main.do">고객센터 메인</a></li>
			<li><a href="qnaboard_list.do">QNA(1:1)</a></li>
			<li><a href="faqboard_list.do">FAQ(일반)</a></li>
			<li><a href="fileboard_list.do">FILE(자료실형)</a></li>
		</ul>
	</nav>
	<main>
		<div align="center">
			<b>자주하는 질문</b>
			<table width="90%" class="ex1">
			</table>
			<table border="1" width="90%" class="ex1">
				<tr align="center" bgcolor="green">
					<th>구분</th>
					<th>제목</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="dto" items="${boardList}">
					<tr align="center">
						<td>[ ${dto.category_title} ]</td>
						<td align="center">
							<a href="faqboard_content.do?num=${dto.num}">
								${dto.title}
							</a>
						</td>
						<td>${dto.readCount}</td>
					</tr>
				</c:forEach>
			</table>
			
		<c:set var="pageCount" value="${pageCount}" />
		<c:set var="pageBlock" value="${pageBlock}" />
		<c:set var="startPage" value="${startPage}" />
		<c:set var="endPage" value="${endPage}" />
		<c:if test="${count > 0}">
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			<c:if test="${startPage > pageBlock}">
				[<a href="qnaboard_list.do?pageNum=${startPage-pageBlock}">이전</a>]
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="qnaboard_list.do?pageNum=${i}">${i}</a>]
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				[<a href="qnaboard_list.do?pageNum=${startPage+pageBlock}">다음</a>]
			</c:if>
		</c:if>
		</div>
	</main>
</section>
	
<%@ include file="../../../bottom.jsp"%>