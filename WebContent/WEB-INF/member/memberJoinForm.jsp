<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:requestEncoding value="euc-kr" />
<html>
<head>
<script type="text/javascript">
	function checkValidate() {

		var expId = /^[a-z0-9]{4,10}$/; //소문자, 숫자로 4~10자
		var expPass = /^[a-zA-Z0-9]{6,15}$/; //소문자, 대문자, 숫자로 6~15자까지
		var expMail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

		if (!expId.test(member_form.idr.value)) {
			alert("아이디가 형식에 맞지 않습니다.")
			member_form.id.focus();
			return false;
		}
		if (member_form.pw.value != member_form.pw2.value) {
			alert("비밀번호가 다릅니다.")
			member_form.pw.focus();
			return false;
		}
		if (!expPass.test(member_form.pw.value)) {
			alert("비밀번호가 형식에 맞지 않습니다.")
			member_form.pw.focus();
			return false;
		} else if (expPass.test(member_form.pw.value)
				&& member_form.pw != memberform.pw2) {
			alert("비밀번호가 일치하지 않습니다.")
			member_form.pw.focus();
			return false;
		}
		if (!expMail.test(member_form.email.value)) {
			alert("이메일 주소가 형식에 맞지 않습니다.")
			member_form.email.focus();
			return false;
		}
		return true;
	}
</script>
<link rel="stylesheet" type="text/css" href="signinStyle.css">
</head>
<body onload="memberform.name.focus()">
	<div align="center">
		<form name="member_form" method="POST" action="member_Insert.do" onsubmit="return checkValidate()">
			<input type="hidden" name="ssn" value="${ssn}"> <input
				type="hidden" name="hp" size="40" value="${hp}">
			<table class="table">
				<caption>
					<img src="img/logo.png">
				</caption>
				<tr>
					<th id="center" style="font-size: 1.5rem">회원가입</th>
				</tr>
				<!-- 53, 65, 68 -->
				<tr>
					<th align="right" id="right" style="height:20px; font-size: 0.9rem;">'*'항목은 필수입력사항입니다.</th>
				</tr>
				<tr>
					<td><input type="text" name="name" value="${name }" readonly="readonly">
				</tr>
				<tr>
					<td>
						<c:if test="${empty memberIdCheckResult}">
						<input type="text" name="id" 
						placeholder="*아이디(영문 소문자, 숫자 4~20자)" maxlength="20"
						style="width: 70%">
						</c:if>
						<c:if test="${!empty memberIdCheckResult && memberIdCheckResult eq true }">
						<script type="text/javascript">
						alert('사용가능한 아이디 입니다.');
						</script>
						<input type="text" name="id" 
						placeholder="*아이디(영문 소문자, 숫자 4~20자)" maxlength="20"
						style="width: 70%" value="${id }" disabled="disabled">
						<input type="hidden" name="idr" value="${id }">
						</c:if>
						<c:if test="${!empty memberIdCheckResult && memberIdCheckResult eq false }">
						<script type="text/javascript">
						alert('중복된 아이디 입니다.');
						</script>
						<input type="text" name="id" 
						placeholder="*아이디(영문 소문자, 숫자 4~20자)" maxlength="20"
						style="width: 70%">
						</c:if>
						
						<input type="button" value="중복확인" 
						onclick="idCheck()" 
						style="height:30px;">
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" name="pw" placeholder="*패스워드(영문 대소문자, 숫자로 6~20자)" maxlength="20"><br>
						
					</td>
				</tr>
				<tr>
					<td><input type="password" name="pw2" class="box" placeholder="*패스워드(영문 대소문자, 숫자로 6~20자)" maxlength="20"></td>
				</tr>

				<tr>
					<td><input type="text" name="email" size="40" maxlength="40" placeholder="이메일"></td>
				</tr>

				<tr>
					<th colspan="2" align="center" id="right"><input type="submit"
						value="가입하기"> <input type="button" value="홈으로"
						onClick="window.location='index.do'"></th>
				</tr>
			</table>
		</form>
	</div>
	
		<script type="text/javascript">
		function idCheck(){
			var id = document.getElementsByName("id")[0].value; 
			location.href="memberIdCheck.do?id="+id+"&name=${name}&ssn=${ssn }&hp=${hp }";
		}
	</script>
	
</body>
</html>
