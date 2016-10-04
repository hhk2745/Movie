<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>


<c:if test="${empty list}">
	<div class="eventContainer">
		<ul style="margin-top: 50px; margin-bottom: 50px;">
			<li><img src="img\main\main_event.png" alt="eventAlt"
				style="width: 1068px;"></li>
		</ul>

		<!-- start -->
		<div class="eventInfoItemContainer">
			<div class="eventImageItem">등록된 이벤트가 없습니다.</div>
			<!-- image -->

			<div class="eventInfoItem"></div>
			<div class="eventButtonItem"></div>
		</div>
	</div>
</c:if>
<c:if test="${!empty list}">
	<c:forEach var="dto" items="${list}">
		<div class="eventContainer">
			<ul style="margin-top: 50px; margin-bottom: 50px;">
				<li><img src="img\main\main_event.png" alt="eventAlt"
					style="width: 1068px;"></li>
			</ul>
			<!-- start -->
			<div class="eventInfoItemContainer">
				<div class="eventImageItem">
					<img src="${pageContext.request.contextPath}/event/${dto.fileName}" height="200px;" width="240px;">
				</div>
				<!-- image -->

				<div class="eventInfoItem">
					<ul>
						<li>이벤트기간 : <strong>${dto.startDate } ~ ${dto.endDate}</strong></li>
						<li><strong>${dto.title }</strong></li>
					</ul>
					<ul>
						<li>${dto.content }
						</li>
					</ul>
				</div>
				<div class="eventButtonItem">
					<button onclick="location.href='clientEventView.do?num=${dto.num}'">
						참여하기<br> <br> GO!
					</button>
				</div>
			</div>
		</div>
	</c:forEach>
</c:if>


<%@ include file="../../bottom.jsp"%>
