<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>비밀번호 찾기</title>
<style>
DIV.brd-list {
	clear: both;
	width: 450;
	table-layout: fixed;
	margin-top: 200px;
	border-bottom: 2px solid #333;
	align: center;
}

DIV.brd-list th {
	background-color: #333;
	white-space: nowrap;
	overflow: hidden;
	text-align: center;
	font: normal 11px dotum, tahoma;
	color: #e1e1e1;
	border-bottom: 2px solid #888;
}

DIV.brd-list a:link, .board_list th a:visited, .board_list th a:active {
	text-decoration: none;
	color: #e1e1e1
}

DIV.brd-list a:hover {
	color: #aaa
}

DIV.brd-list td {
	padding: .1em;
	border-bottom: 1px solid #ddd;
	font: normal 12px gulim, tahoma;
	white-space: nowrap
}

.input {
	font: normal 12px gulim, tahoma;
	color: #555;
}
</style>
</head>
<body>
	<div align="center">
		<div class="brd-list">
			<table>
				<tr>
					<td><h2>
							<img src="../../img/btn_pass_search.png"> 비밀번호 찾기
						</h2></td>
				<tr>
					<td><font size="2px"><BR>비밀번호가 기억나지 않으세요? <br>
							이름, 아이디, 이메일을 입력하여 비밀번호를 확인하실 수 있습니다. <br> 본인인증시 제공되는 정보는 해당
							인증기관에서 직접 수집하며, <br> 인증 이외의 용도로 이용또는 저장하지 않습니다. <br>
							<p></td>
				</tr>
				</font>
				</td>
				</tr>
			</table>

			<form name="searchPWForm" action="member_SearchPW.do" method="post" onsubmit="return searchPWCheck()">
				<table bgcolor="white">

					<tr>
						<th width="150"><font size="2px">이름</font></th>
						<td width="250"><input type="text" name="name" size="20"
							class="input"></td>
					</tr>
					<tr>
						<th width="150"><font size="2px">아이디</font></th>
						<td width="250"><input type="text" name="id" size="20"
							class="input"></td>
					</tr>
					<tr>
						<th width="150"><font size="2px">이메일</font></th>
						<td width="250"><input type="text" name="email" size="35"
							class="input"></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="확인">
							<input type="button" onclick="location.href='member_Login.do'" value="로그인">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	
		<script>
		function searchPWCheck() {
			if (searchPWForm.name.value === "") {
				alert("이름 입력란이 공백입니다.");
				searchPWForm.name.focus();
				return false;
			}

			if (searchPWForm.id.value === "") {
				alert("아이디 입력란이 공백입니다.")
				searchPWForm.id.focus();
				return false;
			}
			
			if (searchPWForm.email.value === "") {
				alert("이메일 입력란이 공백입니다.")
				searchPWForm.email.focus();
				return false;
			}
			return true;
		}
	</script>
	
</body>
</html>