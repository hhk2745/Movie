<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../top.jsp"%>

<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert("로그인이 필요한 작업입니다.");
		location.href="member_Login.do";
	</script>
</c:if>

<section class="content">
	<nav>
		<ul>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="customer_main.do">고객센터 메인</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="qna_writeForm.do">1:1 문의하기</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="faqboard_list.do?mode=전체">자주 찾는 질문</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="fileboard_setting.do">FILE(자료실형)</a></li>
		</ul>
	</nav>
	<main>
		<div align="center">
			<b>문 의 목 록</b>
			<table width="90%" class="ex1">
				<tr bgcolor="yellow">
					<td align="right"><a href="qna_writeForm.do">1:1 문의하기</a></td>
				</tr>
			</table>
			<table border="1" width="90%" class="ex1">
				<tr align="center" bgcolor="green">
					<th>번호</th>
					<th>제목</th>
					<th>작성자 ID</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				<c:choose>
					<c:when test="${empty boardList}">
						<tr>
							<th align="center" colspan="5">문의 내역이 없습니다.</th>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="dto" items="${boardList}">
							<tr align="center">
								<td>${dto.num}</td>
								<td align="left">
									<c:if test="${dto.re_level > 0}">
										<img src="img/level.gif" width="${dto.re_level * 10}">
										<img src="img/re.gif">
									</c:if>
									<a href="qna_content.do?num=${dto.num}">
										${dto.title}
									</a>
								</td>
								<td>${dto.id}</td>
								<td>${dto.readCount}</td>
								<td>${dto.reg_date}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
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
				[<a href="qnaboard_list.do?id=${loginId.id}&pageNum=${startPage-pageBlock}">이전</a>]
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="qnaboard_list.do?id=${loginId.id}&pageNum=${i}">${i}</a>]
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				[<a href="qnaboard_list.do?id=${loginId.id}&pageNum=${startPage+pageBlock}">다음</a>]
			</c:if>
		</c:if>
		</div>
	</main>
</section>
	
<%@ include file="../../../bottom.jsp"%>