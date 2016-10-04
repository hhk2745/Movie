<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../top.jsp"%>

<section class="content">
	<nav>
		<ul>
			<li><a href="customer_main.do">고객센터 메인</a></li>
			<li><a href="qna_writeForm.do">1:1 문의하기</a></li>
			<li><a href="faqboard_list.do?mode=전체">자주 찾는 질문</a></li>
			<li><a href="fileboard_setting.do">FILE(자료실형)</a></li>
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

<c:set var="dto" value="${dto}" />
<c:set var="num" value="${num}" />
<c:choose>
	<c:when test="${empty dto}">
		<c:redirect url="qnaboard_list.do?id=${loginId.id}" />
	</c:when>
<c:otherwise>

<form name="f" action="qnaboard_updatePro.do" method="post" onsubmit="return checkBoard()" enctype="multipart/form-data">
<table align="center" width="90%">
<caption>문 의 수 정</caption>
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
		<td align="center" bgcolor="yellow">제 목</td>
		<td><input type="text" name="title" size="60" value="${dto.title}"></td>
	</tr>
	<tr>
		<td align="center" bgcolor="yellow">내 용</td>
		<td><textArea name="content" cols="60" rows="10">${dto.content}</textArea></td>
	</tr>
	<tr>
		<td bgcolor="yellow" align="center">파일</td>
		<td>
			<c:choose>
				<c:when test="${dto.fileName eq null}">
					<img src="img/null_img.gif" width="80" height="80">
				</c:when>
				<c:otherwise>
					<img src="qnaboard_files/${dto.id}/${dto.fileName}"	width="80" height="80">
				</c:otherwise>
			</c:choose>
			<input type="file" name="fileName">
			<input type="hidden" name="fileName2"value="${dto.fileName}">
		</td>
	</tr>	
	<tr>
		<td colspan="6">
			<input type="hidden" name="num" value="${num}">
			<input type="hidden" name="id" value="${loginId.id}">
			
			<input type="submit" value="글수정">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기" onclick="location.href='qnaboard_list.do?id=${loginId.id}'">
		</td>
	</tr>
</table>
</form>
	</c:otherwise>
</c:choose>
</main>
</section>

<%@ include file="../../../bottom.jsp"%>