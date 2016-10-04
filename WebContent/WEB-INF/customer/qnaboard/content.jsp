<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../top.jsp"%>

<c:if test="${!empty result && result eq true}">
	<script>
		window.open("qna_imgOpen.do?id=${id}&fileName=${fileName}", "", "width=1000, height=500, left=100, top=100"); 
	</script>
</c:if>

<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert("로그인이 필요한 작업입니다.");
		location.href="member_Login.do";
	</script>
</c:if>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/myPage.css">

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
				<li><a href="member_MyPage.do?mode=myInfo">회원 정보</a></li>
				<li><a href="member_MyPage.do?mode=myProfile">프로필 관리</a></li>
				<li style="background-color: rgb(231, 26, 15);"><a href="qnaboard_list.do?id=${loginId.id}" style="color:white">나의
						문의내역</a></li>
			</ul>
		</div>
	</nav>
	<main>
	
		<div align="center">
		<b>문 의 내 용 보 기</b>
		<table border="1" width="90%">
			<tr>
				<th bgcolor="yellow">글번호</th>
				<td align="center">${QNAboardDTO.num}</td>
				<th bgcolor="yellow">작성자 ID</th>
				<td align="center">${QNAboardDTO.id}</td>
			</tr>
			<tr>
				<th bgcolor="yellow">조회수</th>
				<td align="center">${QNAboardDTO.readCount}</td>
				<th bgcolor="yellow">작성일</th>
				<td align="center">${QNAboardDTO.reg_date}</td>
			</tr>
			<tr>
				<th bgcolor="yellow">제목</th>
				<td align="center" colspan="5">${QNAboardDTO.title}</td>
			</tr>
			<tr>
				<th bgcolor="yellow">내용</th>
				<td align="center" colspan="5">${QNAboardDTO.content}</td>
			</tr>
			<c:if test="${!(QNAboardDTO.id eq 'admin')}">
				<tr>
					<th bgcolor="yellow">첨부 이미지</th>
					<td align="center" colspan="5">
						<c:choose>
							<c:when test="${QNAboardDTO.fileName eq null}">
								<img src="img/null_img.gif">
							</c:when>
							<c:otherwise>
								<a href="qna_img.do?id=${QNAboardDTO.id}&fileName=${QNAboardDTO.fileName}&num=${QNAboardDTO.num}">
									<img src="<c:url value="qnaboard_files/${QNAboardDTO.id}/${QNAboardDTO.fileName}"/>" width="150" height="150">
								</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:if>
			<tr>
				<td bgcolor="yellow" align="right" colspan="6">
					<c:if test="${!(QNAboardDTO.id eq 'admin')}">
						<input type="button" value="문의수정" onClick="window.location='qnaboard_updateForm.do?num=${QNAboardDTO.num}'">&nbsp;&nbsp;&nbsp; 
						<input type="button" value="문의취소" onClick="window.location='qnaboard_delete.do?id=${loginId.id}&num=${QNAboardDTO.num}'">&nbsp;&nbsp;&nbsp;
					</c:if>
					<input type="button" value="문의목록" onClick="window.location='qnaboard_list.do?id=${loginId.id}'">
				</td>
			</tr>
		</table>
		</div>
	
	</main>
	<aside>3</aside>
</section>
<%@ include file="../../../bottom.jsp"%>
	
	
	
	<!-- </main>
</section> -->

<%@ include file="../../../bottom.jsp"%>