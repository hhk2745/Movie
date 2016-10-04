<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../admin_top.jsp"%>

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
		<c:redirect url="admin_faqboard_list.do?mode=전체" />
	</c:when>
	<c:otherwise>

<form name="f" action="admin_faqboard_updatePro.do" method="post" onsubmit="return checkBoard()" enctype="multipart/form-data">
<table align="center" width="90%">
<caption>질 문 수 정</caption>
	<tr>
		<th bgcolor="yellow">질문유형</th>
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
			<input type="file" name="fileName">
			<input type="hidden" name="fileName2" value="${dto.fileName}">
		</td>
	</tr>	
	<tr>
		<td colspan="6">
		<input type="hidden" name="num" value="${num}">
		
		<input type="submit" value="수정완료">
		<input type="reset" value="다시작성">
		<input type="button" value="목록보기" onclick="location.href='admin_faqboard_list.do?mode=전체'">
		</td>
	</tr>
</table>
</form>
	</c:otherwise>
</c:choose>

<%@ include file="../admin_bottom.jsp"%>