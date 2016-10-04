<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>

<c:if test="${!empty result && result eq true}">
	<script>
		window.open("admin_faq_imgOpen.do?fileName=${fileName}", "", "width=1000, height=500, left=100, top=100"); 
	</script>
</c:if>

	<div align="center">
	<b>질 문 내 용 보 기</b>
	<table border="1" width="600">
		<tr>
			<th bgcolor="yellow">번호</th>
			<td align="center">${boardDTO.num}</td>
			<th bgcolor="yellow">조회수</th>
			<td align="center">${boardDTO.readCount}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">카테고리</th>
			<td align="center">${boardDTO.category_title}</td>
			<th bgcolor="yellow">작성일</th>
			<td align="center">${boardDTO.reg_date}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">제목</th>
			<td align="center" colspan="3">${boardDTO.title}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">내용</th>
			<td align="center" colspan="3">${boardDTO.content}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">첨부 이미지</th>
			<td colspan="3" align="center">
				<c:choose>
					<c:when test="${boardDTO.fileName eq null}">
						<img src="img/null_img.gif">
					</c:when>
					<c:otherwise>
						<a href="admin_faq_img.do?fileName=${boardDTO.fileName}&num=${boardDTO.num}">
							<img src="<c:url value="admin_faqboard_files/${boardDTO.fileName}"/>" width="150" height="150">
						</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td bgcolor="yellow" align="right" colspan="4">
				<input type="button" value="수정" onClick="window.location='admin_faqboard_updateForm.do?num=${boardDTO.num}'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="삭제" onClick="window.location='admin_faqboard_delete.do?num=${boardDTO.num}'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="목록" onClick="window.location='admin_faqboard_list.do?mode=전체'">
			</td>
		</tr>
	</table>
	</div>

<%@ include file="../admin_bottom.jsp"%>