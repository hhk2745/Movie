<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>

<ul class="submenuBox">
	<a href="EventList.do">
		<li class="subHover effect"><span>이벤트 목록</span></li>
	</a>

	<a href="insertEvent.do">
		<li class="subHover effect"><span>이벤트 추가</span></li>
	</a>
</ul>

<!--  -->

<form name="insertEventForm" action="insertEvent.do" method="post" enctype="multipart/form-data" onsubmit="return checkWrite()">
	<table border="1">
		<tr>
			<th>이벤트 제목</th><td><input type="text" name="title" placeholder="이벤트 제목" width="100%"></td>
		</tr>
		<tr>
			<th>시작일(yyyyMMdd)</th><td><input type="text" name="startDate" maxlength="8" placeholder="yyyyMMdd" width="100%"></td>
		</tr>
		<tr>
			<th>종료일(yyyyMMdd)</th><td><input type="text" name="endDate" maxlength="8" placeholder="yyyyMMdd" width="100%"></td>
		</tr>
		<tr>
			<th>내용</th><td><textarea name="content" cols="60" rows="10" maxlength="100" ></textarea>
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
		if (insertEventForm.event_img.value == "") {
			alert('이벤트 첨부 이미지 선택하세요.');
			return false;
		}
		return true;
	}
</script>

<%@ include file="../admin_bottom.jsp"%>