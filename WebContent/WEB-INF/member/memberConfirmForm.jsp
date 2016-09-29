<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<html>
<head>
<title>이메일 인증</title>
<script type="text/javascript">
	function checkMail() {
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

		if (mail_confirm.clientEmail.value == "") {
			alert("이메일을 입력해 주세요!");
			mail_confirm.clientEmail.focus();
			return false;
		}
		if (exptext.test(mail_confirm.clientEmail.value) == false) {
			alert("이메일의 형식이 올바르지 않습니다.");
			mail_confirm.clientEmail.focus();
			return false;
		}

		alert("인증메일이 전송되었습니다. 인증번호를 입력란에 작성해주세요.");

		return true;
	}
</script>
</head>
<body bgcolor="fefcf0">
	<c:if test="${confirmResult eq true}">
		<script type="text/javascript">
			alert('인증완료');
			self.close();
		</script>
	</c:if>

	<div align="center">
		<form name="mail_confirm" action="confirm2.do" method="post"
			onsubmit="return checkMail()">
			<table border="1" width="600" bgcolor="515151" cellpadding="10"
				cellspacing="5">
				<tr bordercolor="grey">
					<td><font size="5" color="white"><b>&nbsp; 이메일 인증 </b></td>
				</tr>
				<tr>
					<td align="center" bgcolor="fefcf0"><img
						src="img/mailConfirm.jpg"><br> <br> <font size="2"
						color="515151">
							<ul style="text-align: left;">
								<li>개인정보 보호법 준수를 위해 이메일 인증을 하고 있습니다.</li>
								<li>이후에 이메일을 통한 계정찾기와 비밀번호 변경 등을 위해 꼭 필요한 내용입니다.</li>
							</ul> <c:if test="${empty  clientEmail}">
								이메일: <input type="text" name=clientEmail size="30">
								<br>
								<br>
							</c:if> <c:if test="${!empty  clientEmail}">
								이메일: <input type="text" name="clientEmail" size="30"
									value="${clientEmail }" disabled="disabled">
								<br>
								<br>
							</c:if>
					</font> <input type="submit" value="인증메일 전송"> <input type=button
						value="나중에 하기" onclick="self.close()"></td>
				</tr>
			</table>
		</form>
		<form name="number_confirm" action="confirmOk.do" method="post" onsubmit="return checkConfirm()">
			<input type="hidden" name="loginId" value="${loginId.id }">
			<table border="1" width="600" bgcolor="515151" cellpadding="10"
				cellspacing="5">
				<tr>
					<td style="color: white; width: 100px;">인증번호: <input
						type="text" name="confirmNumber" size="6" maxlength="6"> <input
						type="submit" value="확인">
					</td>
				</tr>
			</table>
		</form>

	</div>

	<script type="text/javascript">
		function checkConfirm() {
			var form = document.number_confirm;
			var confirmNumber = ${confirmNumber};

			if (form.confirmNumber.value == "") {
				alert("인증번호를입력하세요");
				return false;
			}
			if (form.confirmNumber.value != confirmNumber) {
				alert(confirmNumber);
				alert("인증번호가 잘못되었습니다. 다시 입력해주세여.");
				return false;
			}
			if (form.confirmNumber.value == confirmNumber) {
				return true;
			}
		}
	</script>

</body>
</html>
