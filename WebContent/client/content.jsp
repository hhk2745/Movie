<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>
<body>
	<c:forEach var="dto" items="${movieList}">
		<c:if test="${sessionScope.num == dto.num }">
			<table border="0">
				<tr>
					<th bgcolor="tomato">개봉일:</th>
					<td align="center">${dto.opendate}</td>
				</tr>
				<tr>
					<th bgcolor="tomato">감독:</th>
					<td align="center">${dto.director}</td>
				</tr>
				<tr>
					<th bgcolor="tomato">출연진:</th>
					<td align="center">${dto.actor}</td>
				</tr>
				<tr>
					<th bgcolor="tomato">장르:</th>
					<td align="center">${dto.genre}</td>
				</tr>
				<tr>
					<th bgcolor="tomato">누적관객:</th>
					<td colspan="3">${dto.watchcount}</td>
				</tr>
				<tr>
					<th><font color="tomato">상영시간: </font></th>
					<td>${dto.runtime}</td>
				</tr>
				<tr>
					<th>줄거리</th>
					<td align="center">${dto.movie_info}</td>
				</tr>

			</table>
		</c:if>
	</c:forEach>
	<!-- movies_info 테이블 내용 불러오면 될거같고 -->
	한줄평 :
	<input type="text" size="62">
	<input type="button" value="등록">
	<c:forEach var="memberdto" items="${list}">
		<div>${memberdto.id}:${memberdto.reply}</div>
	</c:forEach>
	</div>

	<div class="modal-footer">

		<button type="button" class="btn btn-default" data-dismiss="modal"
			onclick="location.href='#'">예매하기</button>
		<!-- <button type="button" class="btn btn-primary">예매하기</button> -->
	</div>
	</div>
</body>
</html>