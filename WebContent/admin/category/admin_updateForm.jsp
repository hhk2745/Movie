<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../admin_top.jsp"%>

<script type="text/javascript">
	function check(){
		if (f.category_title.value==""){
			alert("카테고리명을 입력해 주세요!!");
			f.category_title.focus();
			return false;
		}
		return true;
	}
</script>

<c:set var="dto" value="${dto}" />
<c:choose>
	<c:when test="${empty dto}">
		<c:redirect url="admin_category_list.do" />
	</c:when>
	<c:otherwise>
		<div align="center">
			<form name="f" action="admin_category_updatePro.do" method="post" onsubmit="return check()">
				<table border="1" width="30%">
					<tr bgcolor="yellow">
						<th colspan="2">카테고리 등록</th>
					</tr>
					<tr>
						<th bgcolor="yellow">카테고리명</th>
						<td>
							<input type="text" name="category_title" size="35" value="${dto.category_title}">
						</td>
					</tr>
					<tr>
						<td colspan="2" bgcolor="yellow" align="center">
							<input type="hidden" name="category_num" value="${dto.category_num}">
							
							<input type="submit" value="수정완료">
							<input type="reset" value="다시작성">
							<input type="button" value="목록보기" onclick="location.href='admin_category_list.do'">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</c:otherwise>
</c:choose>

<%@ include file="../admin_bottom.jsp"%>