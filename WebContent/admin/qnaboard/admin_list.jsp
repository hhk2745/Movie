<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../admin_top.jsp"%>

		<div align="center">
			<b>문 의 목 록</b>
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
									<a href="admin_qna_content.do?num=${dto.num}">
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
				[<a href="admin_qnaboard_list.do?pageNum=${startPage-pageBlock}">이전</a>]
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="admin_qnaboard_list.do?pageNum=${i}">${i}</a>]
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				[<a href="admin_qnaboard_list.do?pageNum=${startPage+pageBlock}">다음</a>]
			</c:if>
		</c:if>
		</div>
	
<%@ include file="../admin_bottom.jsp"%>