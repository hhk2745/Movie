<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>

<c:if test="${!empty uploadResult && uploadResult ne true}">
	<script type="text/javascript">
		alert('이벤트정보 수정 실패');
	</script>
</c:if>
<c:if test="${!empty uploadResult && uploadResult ne false}">
<script type="text/javascript">
		alert('이벤트정보 수정 성공');
	</script>
</c:if>

<ul class="submenuBox">
	<a href="EventList.do">
		<li class="subHover effect"><span>이벤트 목록</span></li>
	</a>

	<a href="insertEvent.do">
		<li class="subHover effect"><span>이벤트 추가</span></li>
	</a>
</ul>


<c:if test="${!empty list}">
	<div class="eventListContainer">
		<table>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>시작일</td>
				<td>종료일</td>
				<td>선택</td>
			</tr>
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.num}</td>
					<td><a href="getEvent.do?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.startDate}</td>
					<td>${dto.endDate}</td>
					<td><a href="deleteEvent.do?num=${dto.num }">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</c:if>

<c:if test="${empty list}">
	<div class="eventListContainer">등록된 이벤트가 없습니다.</div>
</c:if>

<%@ include file="../admin_bottom.jsp"%>