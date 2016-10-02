<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>

<c:if test="${!empty isLoginComp && isLoginComp==false}">
	<script type="text/javascript">
		alert("ID,PW를 다시 확인해 주세요.");
	</script>
</c:if>
<c:if test="${!empty loginId}">
	<script type="text/javascript">
		alert("로그인 상태입니다.");
		location.href="index.do";
	</script>
</c:if>
<c:if test="${param.mode eq 'serchID' }">
	<c:if test="${empty serchID}">
		<script type="text/javascript">
			alert('계정 검색 실패');
		</script>
	</c:if>
	<c:if test="${!empty serchID}">
		<script type="text/javascript">
			alert('검색한 결과 : ${serchID.id}');
		</script>
	</c:if>
</c:if>

<c:if test="${param.mode eq 'serchPW' }">
	<c:if test="${empty serchPW}">
		<script type="text/javascript">
			alert('패스워드 찾기  실패');
		</script>
	</c:if>
	<c:if test="${!empty serchPW}">
		<script type="text/javascript">
			alert('id: ${serchPW.id}, pw: ${serchPW.pw}');
		</script>
	</c:if>
</c:if>

<section class="loginContent">
	<nav></nav>
	<div class="memberLoginContainer">
		<div class="loginButtonContainer">
			<button class="loginbtn">로그인</button>
			<button class="nologinbtn">비회원 로그인</button>
		</div>

		<div class="loginFormDiv">
			<form name="login_form" action="member_Login.do" class="loginForm" onsubmit="return checkValidate()" method="post">
				<input type="text" name="id" size="50"
					onclick="if(this.value=='아디를 입력하세여'){this.value=''}"
					value="아디를 입력하세여"><br>
				<br> <input type="password" name="pw" size="50"> <input
					id="submit" type="submit" onsubmit="return checkValidate()"
					value="로그인">
			</form>
		</div>

		<div class="serchDiv">
			<button class="serchDivItem" onclick="location.href='member_SearchID.do'">ID
				찾기</button>
			<button class="serchDivItem" onclick="location.href='member_SearchPW.do'">패스워드
				찾기</button>
			<button class="serchDivItem" onclick="location.href='member_JoinCheck.do'">회 원
				가 입</button>
		</div>
	</div>
	<aside></aside>
</section>


<script type="text/javascript">
	function checkValidate() {
		var expId = /^[a-z0-9]{4,10}$/; //소문자, 숫자로 4~10자
 		if (!expId.test(login_form.id.value)) {
			alert("아이디가 형식에 맞지 않습니다.")
			login_form.id.focus();
			return false;
		}
		return true;
	}
</script>
<%@ include file="../../bottom.jsp"%>
