<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<!-- mobile page 설정 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
</head>

<body>
		<div data-role="header">
			<h1>회원가입</h1>
		</div>
		<div data-role="content">
		<form name="member_form" method="POST" action="member_Insert.do" onsubmit="return checkValidate()">
		<input type="hidden" name="ssn" value="${ssn}">
		<input type="hidden" name="hp" size="40" value="${hp}">
			<table width=40% border="1" align="center">
				<tr>
					<td colspan=3><input type="text" name="id" id="name" placeholder="아이디(영문 소문자, 숫자 4~20자)" />
					</td>
				</tr>

				<tr>
					<td colspan=3><input type="password" name="pw" id="name" value="" maxlength="20" placeholder="비밀번호(영문 소 대문자, 숫자 6~20자)"  /></td>
				</tr>

				<tr>
					<td colspan=3><input type="password" name="pwr" id="name" value="" maxlength="20" placeholder="비밀번호 확인" /></td>
				</tr>

				<tr>
					<td colspan=3>
						<input type="text" name="name" id="name" value="${name}"  disabled="disabled"/>
					</td>
				</tr>

				<tr>
					<td><input type="text" name="email1" id="name" value="" placeholder="이메일" ></td>
					<td colspan='2'>
						<select name="email2">
								<option value="@naver.com">naver.com</option>
								<option value="@gmail.com">gmail.com</option>
								<option value="@daum.net">daum.net</option>
						</select>
					</td>
				</tr>

				<tr>
					<td colspan="3"><textarea name="memo" id="textarea" placeholder="가입인사" ></textarea>
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" value="회원가입" >
						</div>
					</td>
					<td>
						<div align="center">
							<input type="button" value="메인으로" onclick="location.href='index.do'" >
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
		
<script type="text/javascript">
	function checkValidate() {

		var expId = /^[a-z0-9]{4,20}$/; //소문자, 숫자로 4~10자
		var expPass = /^[a-zA-Z0-9]{6,20}$/; //소문자, 대문자, 숫자로 6~15자까지

		if (!expId.test(member_form.id.value)) {
			alert("아이디가 형식에 맞지 않습니다.")
			member_form.id.focus();
			return false;
		}
		if (member_form.pw.value != member_form.pwr.value) {
			alert("비밀번호가 다릅니다.")
			member_form.pw.focus();
			return false;
		}
		if (!expPass.test(member_form.pw.value)) {
			alert("비밀번호가 형식에 맞지 않습니다.")
			member_form.pw.focus();
			return false;
		} else if (expPass.test(member_form.pw.value)
				&& member_form.pw != memberform.pwr) {
			alert("비밀번호가 일치하지 않습니다.")
			member_form.pw.focus();
			return false;
		}
		return true;
	}
</script>
</body>
</html>
