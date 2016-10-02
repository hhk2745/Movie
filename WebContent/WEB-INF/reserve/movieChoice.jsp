<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<c:if test="${!empty loginId && loginId.confirm ne 'ok' }">
	<script type="text/javascript">
		location.href="index.jsp";
	</script>
</c:if>
<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert('로그인 후 이용가능합니다.');
		location.href="member_Login.do";
	</script>
</c:if>
				
<style>
tr.border_bottom td {
  border-bottom:1px solid gray;
}
</style>
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
			<tr><th width="150px"></th><th width="50px"> 연령 </th><th width="200px"> 장르 </th> <th width="300px">배우 </th><th width="100px"></th><th width="100px"></th></tr> </table>
			<div style="overflow-y: auto; width: 100%; height: 700px;">
			<table width="900px">
			<c:forEach var="dto" items="${movieList }">
			
				<tr class="border_bottom">
					<td width="150px"> <img src=" ${pageContext.request.contextPath}/poster/${dto.file_directory}/${ dto.poster }" width="100"></td>
					<td width="50px" align="center"><br>${dto.grade } 세 <br></td>
					<td width="200px" align="center"><br>${dto.genre } <br></td>
					<td width="300px">${dto.actor } <br></td>
					<td width="100px"><br>${dto.runtime } (분)<br></td>
					<td width="100px"><a href="client_theaterReserve.do?num=${dto.num }"> Click</a></td>
				</tr>
			</c:forEach>
			</table>
			</div>
		</form>
	</div>
	</main>

	<aside>aside</aside>
</section>

<%@ include file="../../bottom.jsp"%>