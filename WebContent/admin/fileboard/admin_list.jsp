<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<%@ include file="../admin_top.jsp"%>

<c:if test="${!empty result && result eq true}">
	<script>
		window.open("admin_imgOpen.do?id=${id}&fileName=${fileName}", "", "width=1000, height=500, left=100, top=100"); 
	</script>
</c:if>

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

	<table width="100%">
	<tr>
		<td colspan="2">
			<div align="center">
				<b>파일 게시판</b>
				<table width="90%" class="ex1">
				</table>
			</div>
		</td>
	</tr>
	
	<c:choose>
		<c:when test="${empty boardList}">
			<tr>
				<th align="center" colspan="5">등록된 게시글이 없습니다.</th>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
			<c:set var="count" value="0"/>
				<c:forEach var="dto" items="${boardList}">
				<c:set var="count" value="${count+1}" />
				<td align="center">
					<table border="1" width="30%" height="30%">
						<tr>
							<td width="10">
								<c:choose>
									<c:when test="${dto.profile_state eq 'no'}">
										<img src="img/profile.png" width="60" height="60">
									</c:when>
									<c:otherwise>
										<img src="<c:url value="/profile_img/${dto.id}.jpg"/>" width="60" height="60">
									</c:otherwise>
								</c:choose>
							</td>
							<th align="center" valign="top">${dto.id}</th>
								<td align="center">
									<input type="button" style="width:70pt;height:30pt;" 
									value="&nbsp;&nbsp;&nbsp;삭제&nbsp;&nbsp;&nbsp;"
									onclick="window.location='admin_fileboard_delete.do?num=${dto.num}&id=${dto.id}&fileName=${dto.fileName}'">
								</td>
						</tr>
						<tr>
							<td align="center" colspan="3">
								${dto.content}
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="admin_img.do?id=${dto.id}&fileName=${dto.fileName}">
									<img src="<c:url value="/fileboard_files/${dto.id}/${dto.fileName}" />" 
										width="200px" height="200px" title="클릭하시면 원본 크기로 보실 수 있습니다." >
								</a>
							</td>
						</tr>
					</table>
				</td>
				<c:if test="${count%2==0}">
					</tr><tr>
				</c:if>
				</c:forEach>
			</tr>
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
					[<a href="admin_fileboard_list.do?pageNum=${startPage-pageBlock}">이전</a>]
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					[<a href="admin_fileboard_list.do?pageNum=${i}">${i}</a>]
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					[<a href="admin_fileboard_list.do?pageNum=${startPage+pageBlock}">다음</a>]
				</c:if>
			</c:if>
		</div>

<%@ include file="../admin_bottom.jsp"%>