<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="../../../top.jsp"%>


<style type="text/css">
ul {
	list-style: none;
	font-weight: bold;
	font-size: 20px;
	display: table;
}

li {
	float: left;
	margin: 0px;
	padding: 0px;
	display: block;
}

a {
	text-decoration: none;
	color: inherit;
}
</style>

<c:if test="${param.mode == '전체'}">
	<c:set var="all" value="전체" />
</c:if>

<section class="content">
	<nav>
		<ul>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="customer_main.do">고객센터 메인</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="qna_writeForm.do">1:1 문의하기</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;  background-color: rgb(231, 26, 15);"><a href="faqboard_list.do?mode=전체" style="color: white;">자주 찾는 질문</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="fileboard_setting.do">FILE(자료실형)</a></li>
		</ul>
      
	</nav>
	<main>
	
	
		<ul class="submenuBox">
			<a href="faqboard_list.do?mode=전체">
				<li class="subHover effect"><span>전체</span>&nbsp;|&nbsp;</li>
			</a>
			<c:forEach var="cate" items="${cateList}">
				<a href="faqboard_list.do?mode=${cate.category_title}">
					<li class="subHover effect"><span>${cate.category_title}</span>&nbsp;|&nbsp;</li>
				</a>
			</c:forEach>
		</ul>
	
<c:set var="mode" value="" />

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

	<c:choose>
		<c:when test="${empty boardList}">
			<tr>
				<th align="center" colspan="5">등록된 질문이 없습니다.</th>
			</tr>
		</c:when>
		<c:otherwise>
		
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
					<c:set var="mode" value="${dto.category_title}" />
				</c:forEach>
				
				</c:otherwise>
			</c:choose>
		</table>
			
		<c:set var="pageCount" value="${pageCount}" />
		<c:set var="pageBlock" value="${pageBlock}" />
		<c:set var="startPage" value="${startPage}" />
		<c:set var="endPage" value="${endPage}" />
		
		<c:if test="${all eq '전체'}">
			<c:set var="mode" value="전체" />
		</c:if>
		
		<c:if test="${count > 0}">
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			<c:if test="${startPage > pageBlock}">
				[<a href="faqboard_list.do?mode=${mode}&pageNum=${startPage-pageBlock}">이전</a>]
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="faqboard_list.do?mode=${mode}&pageNum=${i}">${i}</a>]
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				[<a href="faqboard_list.do?mode=${mode}&pageNum=${startPage+pageBlock}">다음</a>]
			</c:if>
		</c:if>
		</div>
	</main>
</section>
	
<%@ include file="../../../bottom.jsp"%>