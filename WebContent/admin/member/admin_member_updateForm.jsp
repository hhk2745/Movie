<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>
<c:set var="dto" value="${dto }"/>
<div align="center">
	<ul class="submenuBox">
		<a href="admin_member.do">
			<li class="subHover effect"><span>회원리스트</span></li>
		</a>
		<!-- <a>
			<li class="subHover effect"><span>+</span></li>
		</a> -->
	</ul>
		<table border="1">
		<tr bgcolor="#ffdab9">
			<th align="center">번호</th>
			<th align="center">이름</th>
			<th align="center">ID</th>
			<th align="center">PW</th>
			<th align="center">Email</th>
			<th align="center">Money</th>
			<th align="center">Point</th>
		</tr>
		<form name="member_update_form" action="admin_member_update.do" method="post">
			 <tr>
						<td><input type="text" name="num" value="${dto.num}"></td>
						<td><input type="text" name="name" value="${dto.name}"></td>
						<td><input type="text" name="id" value="${dto.id}"></td>
						<td><input type="text" name="pw" value="${dto.pw}"></td>
						<td><input type="text" name="email" value="${dto.email}"></td>
						<td><input type="text" name="money" value="${dto.money}"></td>
						<td><input type="text" name="point" value="${dto.point}"></td>
			</tr>
			<tr>
				<td colspan="7" align="right"> <input type="submit" value="수정하기"></td>
			</tr>
		</form>
        
	</table>
</div>
<%@ include file="../admin_bottom.jsp"%>