<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>

<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert("로그인이 필요한 작업입니다.");
		location.href="member_Login.do";
	</script>
</c:if>


<c:if test="${!empty updateNickname  && updateNickname eq true}">
	<script type="text/javascript">
alert("닉네임 등록 성공!");
</script>
</c:if>
<c:if test="${!empty updateNickname && updateNickname eq false }">
	<script type="text/javascript">
alert("닉네임 등록 실패!")
</script>
</c:if>


<link rel="stylesheet" type="text/css" href="myPage.css">
    <!-- Bootstrap -->
    <link href="infoUpdate_css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="infoUpdate_css/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="infoUpdate_css/style.css" media="screen" title="no title" charset="utf-8">
<main id="myPageMain">
<div class="bgImgContainer">
	<div class="myPageContainer">
		<div class="profile">
			<div class="profile_item1">
				<c:if test="${empty loginId.profile_img}">
					프로필 사진을 등록해주세요.<br>
					<strong>[ <a href="member_MyPage.do?mode=myProfile">프로필관리</a> ] </strong>에서 등록 할 수 있습니다.
				</c:if>
				<c:if test="${!empty loginId.profile_img}">
					<img alt="프로필 사진" src="<c:url value="/profile_img/${loginId.profile_img}"/>" width="150px" height="180px">
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
				<li><a href="member_MyPage.do?mode=myInfo">회원 정보 변경</a></li>
				<li style="background-color: rgb(231, 26, 15);"><a
					href="member_MyPage.do?mode=myProfile" style="color:white;">프로필 관리</a></li>
				<li><a href="qnaboard_list.do">나의 문의내역</a></li>
				<li><a href="member_MyPage.do?mode=dropOut">회원탈퇴</a></li>
			</ul>
		</div>
	</nav>


	<main>
	<div class="myProfileContainer">
		<div class="myProfileItem">
		<img src="img\main\myIcon5.png" style="background-color: fefcf0;">
		</div>
		<div class="myProfileItemContainer">
			<div class="myProfileItemContainer_ItemContainer">
				<div class="myProfileItemContainer_ItemContainer_Item">이름</div>
				<div class="myProfileItemContainer_ItemContainer_Item">
					${loginId.name }</div>
			</div>
			<div class="myProfileItemContainer_ItemContainer">
				<div class="myProfileItemContainer_ItemContainer_Item">아이디</div>
				<div class="myProfileItemContainer_ItemContainer_Item">
					${loginId.id }</div>
			</div>
			<div class="myProfileItemContainer_ItemContainer">
				<div class="myProfileItemContainer_ItemContainer_Item">닉네임</div>
				<div class="myProfileItemContainer_ItemContainer_Item"
					style="width: 50px;">
					${loinId.nickname }
					<form name="updateNicknameForm" action="updateNickname.do"
						method="post" onsubmit="return checkNickname()">
						<input type="hidden" name="id" value="${loginId.id }">
						<c:if test="${empty loginId.nickname }">
							<input type="text" name="nickname" value="닉네임을 등록해 주세요."
								onclick="if(this.value=='닉네임을 등록해 주세요.'){this.value=''}">
							<input type="submit" value="등록">
						</c:if>
						<c:if test="${!empty loginId.nickname }">
							<input type="text" name="nickname" value="${loginId.nickname }"
								onclick="if(this.value=='${loginId.nickname }'){this.value=''}">
							<input type="submit" value="변경">
						</c:if>

					</form>
				</div>
			</div>
			<div class="myProfileItemContainer_ItemContainer">
				<div class="myProfileItemContainer_ItemContainer_Item" style="border-bottom: 1px solid black;">
					프로필이미지
				</div>
				<div class="myProfileItemContainer_ItemContainer_Item" style="border-bottom: 1px solid black;">
					<form name="updateProfile_imgForm" action="member_MyProfile.do" method="post" enctype="multipart/form-data" onsubmit="return checkProfile_img()">
						<input type="hidden" name="id" value="${loginId.id }">
						<input type="file" name="profile_img">
					
				</div>
			</div>
		</div>
		<div class="myProfileItem">
			<input type="submit" value="사진 등록하기" onclick="return checkProfileInfo()"
				style="height: 50px; width: 100px; border: 2px solid #ff3c3c; font-size: 1.5rem; font-weight:bold; background-color: #ea5b50; color: #ffffff; margin-left: 800px;">
		</form>
		</div>
		
	</div>
	</main>


	<aside>3</aside>
</section>

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

function checkNickname(){
	if(updateNicknameForm.nickname.value == ""){
		alert("닉네임 입력란이 공백입니다.	");
		return false;
	}
	return true;
}

function checkProfile_img(){
	if(!updateProfile_imgForm.profile_img.value){
		alert("프로필에 등록할 사진을 선택해 주세요.");
		return false;
	}
	return true;
}


</script>
<%@ include file="../../bottom.jsp"%>