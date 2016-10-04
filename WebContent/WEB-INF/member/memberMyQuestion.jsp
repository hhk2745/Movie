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
				<li><a href="member_MyPage.do?mode=myTicket">나의 예매 내역</a></li>
				<li><a href="member_MyPage.do?mode=myPoint">MyPoint</a></li>
				<li><a href="member_MyPage.do?mode=myMoney">MyMoney</a></li>
				<li><a href="member_MyPage.do?mode=myInfo">회원 정보 변경</a></li>
				<li><a href="member_MyPage.do?mode=myProfile">프로필 관리</a></li>
				<li style="background-color: rgb(231, 26, 15);"><a href="qnaboard_list.do?id=${loginId.id}" style="color:white">나의
						문의내역</a></li>
				<li><a href="member_MyPage.do?mode=dropOut">회원탈퇴</a></li>
			</ul>
		</div>
	</nav>
	<main>



	<div align="center">
			<b>문 의 목 록</b>
			<!-- <table width="90%" class="ex1">
				<tr bgcolor="yellow">
					<td align="right"><a href="qna_writeForm.do">1:1 문의하기</a></td>
				</tr>
			</table> -->
			<table border="1" width="90%" class="ex1">
				<tr align="center" bgcolor="green">
					<th>번호</th>
					<th>제목</th>
					<th>작성자 ID</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				<c:choose>
					<c:when test="${empty boardList}">
						<tr>
							<th align="center" colspan="5">문의 내역이 없습니다.</th>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="dto" items="${boardList}">
							<tr align="center">
								<td>${dto.num}</td>
								<td align="left">
									<c:if test="${dto.re_level > 0}">
										<img src="img/level.gif" width="${dto.re_level * 10}">
										<img src="img/re.gif">
									</c:if>
									<a href="qna_content.do?num=${dto.num}">
										${dto.title}
									</a>
								</td>
								<td>${dto.id}</td>
								<td>${dto.readCount}</td>
								<td>${dto.reg_date}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			
		<c:set var="pageCount" value="${pageCount}" />
		<c:set var="pageBlock" value="${pageBlock}" />
		<c:set var="startPage" value="${startPage}" />
		<c:set var="endPage" value="${endPage}" />
		<c:if test="${count > 0}">
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			<c:if test="${startPage > pageBlock}">
				[<a href="qnaboard_list.do?id=${loginId.id}&pageNum=${startPage-pageBlock}">이전</a>]
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="qnaboard_list.do?id=${loginId.id}&pageNum=${i}">${i}</a>]
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				[<a href="qnaboard_list.do?id=${loginId.id}&pageNum=${startPage+pageBlock}">다음</a>]
			</c:if>
		</c:if>
		</div>






	</main>
	<aside>3</aside>
</section>
<%@ include file="../../bottom.jsp"%>