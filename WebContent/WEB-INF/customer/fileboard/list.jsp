<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<%@ include file="../../../top.jsp"%>

<c:if test="${!empty result && result eq true}">
	<script>
		window.open("file_imgOpen.do?id=${id}&fileName=${fileName}", "", "width=1000, height=500, left=100, top=100"); 
	</script>
</c:if>

<section class="content">
<nav>
</nav>
	<main>
	
	<table width="100%">
	<tr>
		<td colspan="2">
			<div align="center">
				<b>인증샷 Event!!</b>
				<table width="90%" class="ex1">
				</table>
				<table width="90%" class="ex1">
					<tr>
						<td align="right">
							<c:if test="${!empty loginId.id}">
								<input type="button" value="글쓰기" onClick="window.location='fileboard_writeForm.do'"><br><br><br>
							</c:if>
						</td>
					</tr>
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
					<table border="1" width="80%" height="80%">
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
							<c:if test="${loginId.id eq dto.id}">
								<td align="right">
									<input type="button" style="width:70pt;height:30pt;" 
										value="&nbsp;&nbsp;&nbsp;수정&nbsp;&nbsp;&nbsp;" 
										onclick="window.location='fileboard_updateForm.do?num=${dto.num}'">
										&nbsp;&nbsp;&nbsp;
									<input type="button" style="width:70pt;height:30pt;" 
									value="&nbsp;&nbsp;&nbsp;삭제&nbsp;&nbsp;&nbsp;"
									onclick="window.location='fileboard_delete.do?num=${dto.num}&id=${loginId.id}&fileName=${dto.fileName}'">
									&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
						</tr>
						<tr>
							<td align="center" colspan="3">
								${dto.content}
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="file_img.do?id=${dto.id}&fileName=${dto.fileName}">
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
					[<a href="fileboard_list.do?pageNum=${startPage-pageBlock}">이전</a>]
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					[<a href="fileboard_list.do?pageNum=${i}">${i}</a>]
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					[<a href="fileboard_list.do?pageNum=${startPage+pageBlock}">다음</a>]
				</c:if>
			</c:if>
		</div>
	</main>
</section>

<%@ include file="../../../bottom.jsp"%>