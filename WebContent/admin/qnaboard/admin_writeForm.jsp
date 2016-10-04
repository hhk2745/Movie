<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../admin_top.jsp"%>

<c:set var="num" value="${num}" />
<c:set var="re_step" value="${re_step}" />
<c:set var="re_level" value="${re_level}" />
<c:set var="recipient" value="${recipient}" />
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
			<form name="f" action="admin_qnaboard_writePro.do" method="post" onsubmit="return checkBoard()">
			<table border="1" width="90%">
				<tr bgcolor="yellow">
					<th colspan="2">문의 답변</th>
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
					<td colspan="3" bgcolor="yellow" align="center">
						<input type="hidden" name="id" value="admin">
						<input type="hidden" name="category" value="${category}">
						<input type="hidden" name="num" value="${num}">
						<input type="hidden" name="re_step" value="${re_step}">
						<input type="hidden" name="re_level" value="${re_level}">
						<input type="hidden" name="recipient" value="${recipient}">
					
						<input type="submit" value="답변달기">
						<input type="reset" value="다시쓰기">
						<input type="button" value="목록보기" onClick="window.location='admin_qnaboard_list.do'">
					</td>
				</tr>
			</table>
			</form>
		</div>

<%@ include file="../admin_bottom.jsp"%>