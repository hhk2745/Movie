<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>

<!--  -->

<form name="updateEventForm" action="updateEventPro.do" method="post" enctype="multipart/form-data" onsubmit="return checkWrite()">
	<input type="hidden" name="num" value="${dto.num}">
	<table border="1">
		<tr>
			<th>이벤트 제목</th><td><input type="text" name="title" value="${dto.title }" placeholder="이벤트 제목" width="100%"></td>
		</tr>
		<tr>
			<th>시작일(yyyyMMdd)</th><td><input type="text" name="startDate" maxlength="8" placeholder="yyyyMMdd" width="100%" value="${dto.startDate }"></td>
		</tr>
		<tr>
			<th>종료일(yyyyMMdd)</th><td><input type="text" name="endDate" maxlength="8" placeholder="yyyyMMdd" width="100%" value="${dto.endDate }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" cols="60" rows="10" maxlength="100">${dto.content }</textarea>
		</tr>
		<tr>
			<th>이미지파일</th><td><input type="file" name="event_img"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="등록">
			</td>
		</tr>
	</table>
</form>

<script>
	function checkWrite() {
		if (insertEventForm.title.value == "") {
			alert('이벤트 제목을 입력하세요.');
			return false;
		}
		if (insertEventForm.startDate.value == "") {
			alert('이벤트 시작일을 입력하세요.');
			return false;
		}
		if (insertEventForm.endDate.value == "") {
			alert('이벤트 종료일을 입력하세요.');
			return false;
		}
		return true;
	}
</script>

<%@ include file="../admin_bottom.jsp"%>