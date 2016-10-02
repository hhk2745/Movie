<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>

<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert("로그인이 필요한 작업입니다.");
		location.href="member_Login.do";
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
				<li style="background-color: rgb(231, 26, 15);"><a href="member_MyPage.do?mode=myTicket" style="color:white">나의 예매 내역</a></li>
				<li><a href="member_MyPage.do?mode=myPoint">MyPoint</a></li>
				<li><a href="member_MyPage.do?mode=myMoney">MyMoney</a></li>
				<li><a href="member_MyPage.do?mode=myInfo">회원 정보 변경</a></li>
				<li><a href="member_MyPage.do?mode=myProfile">프로필 관리</a></li>
				<li><a href="qnaboard_list.do">나의 문의내역</a></li>
				<li><a href="member_MyPage.do?mode=dropOut">회원탈퇴</a></li>
			</ul>
		</div>
	</nav>
	<main><div style="padding: 60px">

		<h2>내 최근 예매 내역</h2>
		<hr />
		<c:choose>
			<c:when test="${empty listTicket and empty listTicketDC}">
		최근 예매한 티켓이 없습니다.
	</c:when>
			<c:otherwise>
				<div style="overflow-y: auto; width: 100%; height: 700px;">
					<table width="100%"  align="center">
						<c:set var="child" value="15" />

						<c:forEach var="dto" items="${listTicket}">
							<tr>
								<td>${dto.day }</td>
								<td>${dto.title }</td>
								<td>${dto.theater }</td>
								<td>${dto.theaternum } 상영관</td>
								<td>${dto.time }</td>
								<td><c:choose>
										<c:when test="${dto.age eq child}">
					청소년
				</c:when>
										<c:otherwise>
					일반 
				</c:otherwise>
									</c:choose></td>
								<td height="30px">${dto.sitnum }</td>
								<td>${dto.price }원</td>
								<td><a href="myTicketDelete.do?num=${dto.num }">취소</a></td>
							</tr>
						</c:forEach>

						<c:forEach var="dtoDC" items="${listTicketDC}">
							<tr>
								<td>${dtoDC.day }</td>
								<td>${dtoDC.title }</td>
								<td>${dtoDC.theater }</td>
								<td>${dtoDC.theaternum } 상영관</td>
								<td>${dtoDC.time }</td>
								<td><c:choose>
										<c:when test="${dtoDC.age eq child}">
					청소년
				</c:when>
										<c:otherwise>
					일반 
				</c:otherwise>
									</c:choose></td>
								<td height="30px">${dtoDC.sitnum }</td>
								<td>${dtoDC.price }원</td>
								<td></td>
							</tr>
						</c:forEach>

					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	</main>
	<aside>3</aside>
</section>
<%@ include file="../../bottom.jsp"%>