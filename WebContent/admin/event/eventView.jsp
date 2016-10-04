<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>

<c:if test="${empty dto}">
이벤트정보를 불러올 수 없습니다.
</c:if>
<c:if test="${!empty dto}">
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${dto.num }</td>
		</tr>
		<tr>
			<th>타이틀</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>시작일</th>
			<td>${dto.startDate }</td>
		</tr>
		<tr>
			<th>종료일</th>
			<td>${dto.endDate }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content }</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><img
				src="${pageContext.request.contextPath}/event/${dto.fileName}"
				width="300px"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="button" value="수정하기" onclick="location.href='updateEvent.do?num=${dto.num}'"></td>
		</tr>
	</table>

</c:if>
<%@ include file="../admin_bottom.jsp"%>