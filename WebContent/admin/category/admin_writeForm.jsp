<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<div align="center">
			<form name="f" action="admin_category_writePro.do" method="post" onsubmit="return check()">
			<table border="1" width="30%">
				<tr bgcolor="yellow">
					<th colspan="2">카테고리 등록</th>
				</tr>
				<tr>
					<th bgcolor="yellow">카테고리명</th>
					<td>
						<input type="text" name="category_title" size="35">
					</td>
				</tr>	
				<tr>
					<td colspan="2" bgcolor="yellow" align="center">
						<input type="submit" value="등록">
						<input type="reset" value="리셋">
						<input type="button" value="목록보기" onClick="window.location='admin_category_list.do'">
					</td>
				</tr>
			</table>
			</form>
		</div>

<%@ include file="../admin_bottom.jsp"%>