<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../top.jsp"%>
<section class="content">
	<nav>
		<ul>
			<li>html</li>
			<li>css</li>
			<li>javascript</li>
		</ul>
	</nav>

	<main> <!-- 영화 선택 페이지   /   영화 정보에서 넘어갈 경우 이 페이지 스킵 -->
	<div style="padding-left: 40px">
	<br><br><br>
	<font style="font-family: 'Times New Roman'; font-size: 30px; font-weight: bold;"  > M o v i e </font><br><br>
	
	<hr/>
		<form name="" action="client_theaterReserve.do" method="post">
		<table width="900px">
			<c:forEach var="dto" items="${movieList }">
				<tr>
					<td> <img src=" ${pageContext.request.contextPath}/poster/${dto.file_directory}/${ dto.poster }" width="100"></td>
					<td><br>${dto.grade }<br></td>
					<td><br>${dto.movie_info } <br></td>
					<td><br>${dto.actor } <br></td>
					<td><a href="client_theaterReserve.do?num=${dto.num }"> 선택</a></td>
				</tr>
			</c:forEach>
		</table>
		</form>
	</div>
	</main>

	<aside>aside</aside>
</section>

<%@ include file="../../bottom.jsp"%>