<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../admin_top.jsp"%>

<ul class="submenuBox">
	<a href="admin_faqboard_list.do?mode=전체">
      <li class="subHover effect"><span>자주 찾는 질문</span></li>
   </a>
   <a href="admin_qnaboard_list.do?mode=전체">
      <li class="subHover effect"><span>1:1문의</span></li>
   </a>
	<a href="admin_fileboard_list.do">
		<li class="subHover effect"><span>File게시판</span></li>
	</a>
	<a href="admin_category_list.do">
		<li class="subHover effect"><span>카테고리 관리</span></li>
	</a>
</ul>

			<table width="100%"">
				<tr>
					<td colspan="3">
						<div align="center">
							<b>카 테 고 리 목 록</b>
							<table width="90%" class="ex1">
							</table>
							<table width="90%" class="ex1">
								<tr>
									<td align="right">
										<input type="button" value="카테고리 등록" onClick="window.location='admin_category_writeForm.do'"><br>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1">
				<tr align="center" bgcolor="green">
					<th>카테고리 번호</th>
					<th>카테고리명</th>
					<th>수정 | 삭제</th>
				</tr>
				<c:choose>
					<c:when test="${empty categoryList}">
						<tr>
							<th align="center" colspan="5">등록된 카테고리가 없습니다.</th>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="dto" items="${categoryList}">
							<tr align="center">
								<td>${dto.category_num}</td>
								<td>${dto.category_title}</td>
								<td>
									<a href="admin_category_updateForm.do?category_num=${dto.category_num}">수정</a> | 
									<a href="admin_category_delete.do?category_num=${dto.category_num}">삭제</a>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		<div align="center">	
			<c:set var="pageCount" value="${pageCount}" />
			<c:set var="pageBlock" value="${pageBlock}" />
			<c:set var="startPage" value="${startPage}" />
			<c:set var="endPage" value="${endPage}" />
			<c:if test="${count > 0}">
				<c:if test="${endPage > pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>
				<c:if test="${startPage > pageBlock}">
					[<a href="admin_category_list.do?pageNum=${startPage-pageBlock}">이전</a>]
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					[<a href="admin_category_list.do?pageNum=${i}">${i}</a>]
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					[<a href="admin_category_list.do?pageNum=${startPage+pageBlock}">다음</a>]
				</c:if>
			</c:if>
		</div>
	
<%@ include file="../admin_bottom.jsp"%>