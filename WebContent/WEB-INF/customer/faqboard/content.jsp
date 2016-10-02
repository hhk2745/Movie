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
	<b>질 문 상 세 보 기</b>
	<table border="1" width="600">
		<tr>
			<th bgcolor="yellow">구분</th>
			<td align="center">[ ${boardDTO.category_title} ]</td>
			<th bgcolor="yellow">조회수</th>
			<td align="center">${boardDTO.readCount}</td>
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
				<input type="button" value="목록보기" onClick="window.location='faqboard_list.do?mode=전체'">
			</td>
		</tr>
	</table>
	</div>
	</main>
</section>

<%@ include file="../../../bottom.jsp"%>