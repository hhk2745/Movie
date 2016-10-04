<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Bootstrap -->
    <link href="infoUpdate_css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="infoUpdate_css/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="infoUpdate_css/style.css" media="screen" title="no title" charset="utf-8">
    
    
<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert("로그인이 필요한 작업입니다.");
		location.href = "member_Login.do";
	</script>
</c:if>

<link rel="stylesheet" type="text/css" href="myPage.css">
<main id="myPageMain">
<div class="bgImgContainer">
	<div class="myPageContainer">
		<div class="profile">
			<div class="profile_item1">
				<c:if test="${empty loginId.profile_img}">
					프로필 사진을 등록해주세요.<br>
					<strong>[ <a href="member_MyPage.do?mode=myProfile">프로필관리</a>
						]
					</strong>에서 등록 할 수 있습니다.
				</c:if>
				<c:if test="${!empty loginId.profile_img}">
					<img alt="프로필 사진"
						src="<c:url value="/profile_img/${loginId.profile_img}"/>"
						width="150px" height="180px">
				</c:if>
			</div>
			<div class="profile_itemContainer">
				<div class="profile_itemContainer_nameId">
					<strong><c:out value="${loginId.name }" /></strong>님 &nbsp;&nbsp;
					<c:out value=" [ 아아디 : ${loginId.id } ]" />
					<c:if test="${empty loginId.nickname}">
						닉네임을 등록해주세요.<br>
						[ 프로필관리 ] 에서 등록 할 수 있습니다.
					</c:if>
					<c:if test="${!empty loginId.nickname}">
						<c:out value=" [ 닉네임 : ${loginId.nickname } ]" />
					</c:if>
				</div>
				<div class="profile_itemContainer_grade">
					<c:out value="${year }" />
					년도 고객님의 등급은
					<%-- <c:out value="${loginId.grade}"/> --%>
					일반 입니다.
				</div>
			</div>
			<div class="profile_item3"></div>
		</div>
		<div class="profile_money">
			<div class="profile_money_money">
				<c:out value="${loginId.money }" />
				원
			</div>
			<div class="profile_money_point">
				<c:out value="${loginId.point }" />
				point
			</div>
			<div class="profile_money_favorite">favorite</div>
		</div>
	</div>
</div>
</main>
<section class="myPageContent">
	<nav>
		<div class="navContainer">
			<ul>
				<c:if test="">

				</c:if>
				<li><a href="member_MyPage.do?mode=myPageMain">MyPageHome</a></li>
				<li><a href="member_MyPage.do?mode=myTicket">나의 예매 내역</a></li>
				<li><a href="member_MyPage.do?mode=myPoint">MyPoint</a></li>
				<li><a href="member_MyPage.do?mode=myMoney">MyMoney</a></li>
				<li style="background-color: rgb(231, 26, 15);"><a
					href="member_MyPage.do?mode=myInfo" style="color: white">회원 정보
						변경</a></li>
				<li><a href="member_MyPage.do?mode=myProfile">프로필 관리</a></li>
				<li><a href="qnaboard_list.do?id=${loginId.id}">나의 문의내역</a></li>
				<li><a href="member_MyPage.do?mode=dropOut">회원탈퇴</a></li>
			</ul>
		</div>
	</nav>
	<main> <%-- <form name="MyInfoForm" action="member_MyPage.do" method="post" onsubmit="return dropOutCheck()">
			<input type="hidden" name="mode" value="myInfoPwCheck">
			<input type="hidden" name="memberNum" value="${loginId.num }">
			패스워드 : <input type="password" name="initPw" placeholder="패스워드를 입력해 주세요.">
			<input type="submit" value="확인">  
		</form> --%>

      <article class="container">
        <div class="page-header">
          <h1>본인 확인을 위해 비밀번호를 입력해 주세요.</h1>
        </div>
        <div class="col-md-6 col-md-offset-3" style="margin-left: 5%">
		<form name="MyInfoForm" action="member_MyPage.do" method="post" onsubmit="return dropOutCheck()">
			<input type="hidden" name="mode" value="myInfoPwCheck">
			<input type="hidden" name="memberNum" value="${loginId.num }">
            <div class="form-group">
              <label for="InputPassword1">비밀번호</label>
              <input name="initPw" type="password" class="form-control" id="InputPassword1" placeholder="소문자, 대문자, 숫자로 6~15자까지">
            </div>
            <div class="form-group text-center">
              <button type="submit" class="btn btn-info">확인<i class="fa fa-check spaceLeft"></i></button>
              <input type="button" class="btn btn-info" onclick="location.href='index.do'" value="홈으로">
            </div>
            
          </form>
        </div>
      </article>


	</main>
	<aside>3</aside>
</section>

<script type="text/javascript">
	function dropOutCheck() {
		if (MyInfoForm.initPw.value == "") {
			alert('패스워드를 입력해 주세요.');
			MyInfoForm.initPw.focus();
			return false;
		}
		if (MyInfoForm.initPw.value != "${loginId.pw}") {
			alert('패스워드가 틀렸습니다.');
			MyInfoForm.initPw.focus();
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