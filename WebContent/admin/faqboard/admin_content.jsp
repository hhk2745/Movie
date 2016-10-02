<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>

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
			<td bgcolor="yellow" align="right" colspan="4">
				<input type="button" value="수정" onClick="window.location='admin_faqboard_updateForm.do?num=${boardDTO.num}'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="삭제" onClick="window.location='admin_faqboard_delete.do?num=${boardDTO.num}'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="목록" onClick="window.location='admin_faqboard_list.do?mode=전체'">
			</td>
		</tr>
	</table>
	</div>

<%@ include file="../admin_bottom.jsp"%>