<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../../top.jsp"%>

<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert("로그인이 필요한 작업입니다.");
		location.href="member_Login.do";
	</script>
</c:if>

<section class="content">
	<nav>
		<ul>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="customer_main.do">고객센터 메인</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px; background-color: rgb(231, 26, 15);"><a href="qna_writeForm.do" style="color:white;">1:1 문의하기</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="faqboard_list.do?mode=전체">자주 찾는 질문</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="fileboard_setting.do">FILE(자료실형)</a></li>
		</ul>
	</nav>
	<main>
		<script type="text/javascript">
			function checkBoard(){
				if (f.category.value=="default"){
					alert("문의유형을 선택해 주세요.");
					f.category.focus();
					return false;
				}
				if (f.title.value==""){
					alert("제목을 입력해 주세요.");
					f.title.focus();
					return false;
				}
				if (f.content.value==""){
					alert("내용을 입력해 주세요.");
					f.content.focus();
					return false;
				}
				return true;
			}
		</script>
			<div align="center">
			<form name="f" action="qnaboard_writePro.do" method="post" onsubmit="return checkBoard()" enctype="multipart/form-data">
			<table border="1" width="90%">
				<tr bgcolor="yellow">
					<th colspan="2">1:1 문의하기</th>
				</tr>
				<tr>
					<th bgcolor="yellow">문의유형</th>
					<td>
						<select name="category">
							<option value="default" selected>선택하세요.</option>
							<c:forEach var="dto" items="${categoryList}">
								<option value="${dto.category_num}">${dto.category_title}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th bgcolor="yellow">제목</th>
					<td><input type="text" name="title" size="60"></td>
				</tr>	
				<tr>
					<th bgcolor="yellow">내용</th>
					<td><textarea name="content" cols="60" rows="10"></textarea></td>
				</tr>
				<tr>
					<th bgcolor="yellow">첨부파일</th>
					<td><input type="file" name="fileName"></td>
				</tr>
				<tr>
					<td colspan="3" bgcolor="yellow" align="center">
						<input type="hidden" name="id" value="${loginId.id}">
					
						<input type="submit" value="문의하기">
						<input type="reset" value="다시쓰기">
						<input type="button" value="목록보기" onClick="window.location='qnaboard_list.do?id=${loginId.id}'">
					</td>
				</tr>
			</table>
			</form>
		</div>
		</main>
	</section>

<%@ include file="../../../bottom.jsp"%>