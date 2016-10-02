<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../top.jsp"%>

<section class="content">
	<nav>
		<ul>
			<li><a href="customer_main.do">고객센터 메인</a></li>
			<li><a href="qna_writeForm.do">QNA(1:1)</a></li>
			<li><a href="faqboard_list.do?mode=전체">FAQ(일반)</a></li>
			<li><a href="fileboard_setting.do">FILE(자료실형)</a></li>
		</ul>
	</nav>
	<main>
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
				<input type="button" value="문의수정" onClick="window.location='qnaboard_updateForm.do?num=${QNAboardDTO.num}'">&nbsp;&nbsp;&nbsp; 
				<input type="button" value="문의취소" onClick="window.location='qnaboard_delete.do?num=${QNAboardDTO.num}'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="문의목록" onClick="window.location='qnaboard_list.do'">
			</td>
		</tr>
	</table>
	</div>
	</main>
</section>

<%@ include file="../../../bottom.jsp"%>