<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>

<c:if test="${!empty result && result eq true}">
	<script>
		window.open("admin_qna_imgOpen.do?id=${id}&fileName=${fileName}", "", "width=1000, height=500, left=100, top=100"); 
	</script>
</c:if>

	<div align="center">
	<b>문 의 내 용 보 기</b>
	<table border="1" width="90%">
		<tr>
			<th bgcolor="yellow">글번호</th>
			<td align="center">${QNAboardDTO.num}</td>
			<th bgcolor="yellow">작성자 ID</th>
			<td align="center">${QNAboardDTO.id}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">조회수</th>
			<td align="center">${QNAboardDTO.readCount}</td>
			<th bgcolor="yellow">작성일</th>
			<td align="center">${QNAboardDTO.reg_date}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">제목</th>
			<td align="center" colspan="5">${QNAboardDTO.title}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">내용</th>
			<td align="center" colspan="5">${QNAboardDTO.content}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">첨부 이미지</th>
			<td align="center" colspan="5">
				<c:choose>
					<c:when test="${QNAboardDTO.fileName eq null}">
						<img src="img/null_img.gif">
					</c:when>
					<c:otherwise>
						<a href="admin_qna_img.do?id=${QNAboardDTO.id}&fileName=${QNAboardDTO.fileName}&num=${QNAboardDTO.num}">
							<img src="<c:url value="qnaboard_files/${QNAboardDTO.id}/${QNAboardDTO.fileName}"/>" width="150" height="150">
						</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td bgcolor="yellow" align="right" colspan="6">
				<input type="button" value="문의답변" onClick="window.location='admin_qna_writeForm.do?category=${QNAboardDTO.category}&num=${QNAboardDTO.num}&re_step=${QNAboardDTO.re_step}&re_level=${QNAboardDTO.re_level}&recipient=${QNAboardDTO.id}'">&nbsp;&nbsp;&nbsp; 
				<input type="button" value="문의삭제" onClick="window.location='admin_qnaboard_delete.do?num=${QNAboardDTO.num}&id=${QNAboardDTO.id}'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="문의목록" onClick="window.location='admin_qnaboard_list.do'">
			</td>
		</tr>
	</table>
	</div>

<%@ include file="../admin_bottom.jsp"%>