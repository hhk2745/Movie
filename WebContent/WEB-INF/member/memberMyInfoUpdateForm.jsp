<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<link rel="stylesheet" type="text/css" href="myPage.css">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Bootstrap -->
    <link href="infoUpdate_css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="infoUpdate_css/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="infoUpdate_css/style.css" media="screen" title="no title" charset="utf-8">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert("로그인이 필요한 작업입니다.");
		location.href="member_Login.do";
	</script>
</c:if>

<c:if test="${!empty dropOutResult && dropOutResult eq true}">
	<script type="text/javascript">
		confirm('정말 회원 탈퇴하시겠습니까? <br> 회원탈퇴 시 남아있는 잔액 및 point는 모두 소멸합니다.');	</script>
</c:if>

<section class="myPageContent">
	<nav>
		<div class="navContainer">
			<ul>
				<c:if test="">

				</c:if>
				<li><a href="member_MyPage.do?mode=myPageMain">MyPageHome</a></li>
				<li ><a href="member_MyPage.do?mode=myTicket">나의 예매 내역</a></li>
				<li><a href="member_MyPage.do?mode=myPoint">MyPoint</a></li>
				<li><a href="member_MyPage.do?mode=myMoney">MyMoney</a></li>
				<li style="background-color: rgb(231, 26, 15);"><a href="member_MyPage.do?mode=myInfo" style="color:white">회원 정보 변경</a></li>
				<li><a href="member_MyPage.do?mode=myProfile">프로필 관리</a></li>
				<li><a href="qnaboard_list.do">나의 문의내역</a></li>
				<li><a href="member_MyPage.do?mode=dropOut">회원탈퇴</a></li>
			</ul>
		</div>
	</nav>
	<main>

			<!-- 수정 form -->
      <article class="container">
        <div class="page-header">
          <h1>회원 정보 수정</h1>
        </div>
        <div class="col-md-6 col-md-offset-3" style="margin-left: 5%">
		<form name="memberInfoUpdateForm" action="member_MyPage.do" method="post" onsubmit="return memberInfoUpdateCheck()">
			<input type="hidden" name="mode" value="myInfo">
			<input type="hidden" name="memberNum" value="${dto.num}">
            <div class="form-group">
              <label for="InputEmail">이메일 주소</label>
              <input name="email" value="${dto.email }" type="email" class="form-control" id="InputEmail" placeholder="이메일 주소">
            </div>
            <div class="form-group">
              <label for="InputPassword1">비밀번호</label>
              <input name="pw" type="password" class="form-control" id="InputPassword1" placeholder="소문자, 대문자, 숫자로 6~15자까지">
            </div>
            <div class="form-group">
              <label for="InputPassword2">비밀번호 확인</label>
              <input name="pwr" type="password" class="form-control" id="InputPassword2" placeholder="비밀번호 확인">
              <p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
            </div>
            <div class="form-group">
              <label for="username">이름</label>
              <input name="name" value="${dto.name }"  type="text" class="form-control" id="username" placeholder="이름을 입력해 주세요">
            </div>
            <div class="form-group text-center">
              <button type="submit" class="btn btn-info">수정하기<i class="fa fa-check spaceLeft"></i></button>
              <input type="button" class="btn btn-info" onclick="location.href='index.do'" value="홈으로">
            </div>
          </form>
        </div>
      </article>


			<!--  -->
	</main>
	<aside>3</aside>
</section>

<script type="text/javascript">
function memberInfoUpdateCheck(){
	var expPass = /^[a-zA-Z0-9]{6,15}$/; //소문자, 대문자, 숫자로 6~15자까지
	var expMail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
	if(memberInfoUpdateForm.pw.value == ""){
		alert('패스워드를 입력해 주세요.');
		return false;
	}
	if(memberInfoUpdateForm.pw.value != memberInfoUpdateForm.pwr.value){
		alert('패스워드가 틀렸습니다.');
		memberInfoUpdateForm.pw.focus();
		return false;
	}
	if (!expPass.test(memberInfoUpdateForm.pw.value)) {
		alert("패스워드가 형식에 맞지 않습니다.")
		memberInfoUpdateForm.pw.focus();
		return false;
	}
	if (memberInfoUpdateForm.pw.value === "${dto.pw}") {
		alert("이전 패스워드와 일치합니다.")
		memberInfoUpdateForm.pw.focus();
		return false;
	}
	
	if(memberInfoUpdateForm.email.value == ""){
		alert('이메일 입력란이 공백입니다.');
		memberInfoUpdateForm.email.focus();
		return false;
	}
	if(memberInfoUpdateForm.name.value == ""){
		alert('이름이 공백입니다.');
		memberInfoUpdateForm.name.focus();
		return false;
	}
	if (!expMail.test(memberInfoUpdateForm.email.value)) {
		alert("이메일 주소가 형식에 맞지 않습니다.")
		memberInfoUpdateForm.email.focus();
		return false;
	}
	
	
	
	return true;
}
</script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="infoUpdate_js/bootstrap.min.js"></script>

<%@ include file="../../bottom.jsp"%>