<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<section class="content">
	<nav>
		<ul>
			<li style="padding-left: 10px;"><a href="fileboard_writeForm.do">작성하러가기</a></li>
			
			<li style="padding-left: 10px;"><a href="fileboard_setting.do">사람들이 남긴 글 보기</a></li>
		</ul>
	</nav>

	<main>
		<div class="clientEventViewContainer">
			<div class="clientEventViewItem">
				${dto.title }
			</div>
			<div class="clientEventViewItem">
				이벤트기간 : ${dto.startDate } ~ ${dto.endDate }
			</div>
			<div class="clientEventViewItem">
				<img src="${pageContext.request.contextPath}/event/${dto.fileName}" height="200px;" width="240px;">
				${dto.content }
			</div>
		</div>
	</main>
	
	
</section>
<%@ include file="../../bottom.jsp"%>