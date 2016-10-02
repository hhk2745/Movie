<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="../admin_top.jsp"%>

<ul class="submenuBox">
	<a href="admin_faqboard_list.do?mode=전체">
		<li class="subHover effect"><span>FAQ게시판</span></li>
	</a>
	<a href="admin_qnaboard_list.do">
		<li class="subHover effect"><span>QNA게시판</span></li>
	</a>
	<a href="admin_fileboard_list.do">
		<li class="subHover effect"><span>File게시판</span></li>
	</a>
	<a href="admin_category_list.do">
		<li class="subHover effect"><span>카테고리 관리</span></li>
	</a>
</ul>

<c:if test="${param.mode == '전체'}">
	<c:set var="all" value="전체" />
</c:if>

<ul class="submenuBox">
	<a href="admin_faqboard_list.do?mode=전체" />
		<li class="subHover effect"><span>전체</span></li>
	</a>
	<c:forEach var="cate" items="${cateList}">
		<a href="admin_faqboard_list.do?mode=${cate.category_title}">
			<li class="subHover effect"><span>${cate.category_title}</span></li>
		</a>
	</c:forEach>
</ul>

<c:set var="mode" value="" />

		<div align="center">
			<b>F A Q 목 록</b>
			<table width="90%" class="ex1">
				<tr bgcolor="yellow">
					<td align="right">
						<a href="admin_faq_writeForm.do">질문등록</a>
					</td>
				</tr>
			</table>
			<table border="1" width="90%" class="ex1">
				<tr align="center" bgcolor="green">
					<th>번호</th>
					<th>구분</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일</th>
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
								<td>${dto.num}</td>
								<td>${dto.category_title}</td>
								<td align="center">
									<a href="admin_faqboard_content.do?num=${dto.num}">
										${dto.title}
									</a>
								</td>
								<td>${dto.readCount}</td>
								<td>${dto.reg_date}</td>
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
				[<a href="admin_faqboard_list.do?mode=${mode}&pageNum=${startPage-pageBlock}">이전</a>]
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="admin_faqboard_list.do?mode=${mode}&pageNum=${i}">${i}</a>]
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				[<a href="admin_faqboard_list.do?mode=${mode}&pageNum=${startPage+pageBlock}">다음</a>]
			</c:if>
		</c:if>
		</div>
	
<%@ include file="../admin_bottom.jsp"%>