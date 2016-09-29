<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>

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
			<td bgcolor="yellow" align="right" colspan="6">
				<input type="button" value="문의답변" onClick="window.location='admin_qna_writeForm.do?num=${QNAboardDTO.num}&re_step=${QNAboardDTO.re_step}&re_level=${QNAboardDTO.re_level}&recipient=${QNAboardDTO.id}'">&nbsp;&nbsp;&nbsp; 
				<input type="button" value="문의삭제" onClick="window.location='admin_qnaboard_delete.do?num=${QNAboardDTO.num}'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="문의목록" onClick="window.location='admin_qnaboard_list.do'">
			</td>
		</tr>
	</table>
	</div>

<%@ include file="../admin_bottom.jsp"%>