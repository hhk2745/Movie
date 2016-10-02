<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css"/>


<div align="center">
	<ul class="submenuBox">

		<li></li>

	</ul>
	
<table border="1" width="800">
<tr align="left" class="m2" height="50">
	<th colspan="2"><font size="5" style="font-weight: bold;">&nbsp;&nbsp;&nbsp;${month}월 매출정보</font></th>
</tr>
<c:set var="k" value="0"/>	
<c:set var="term" value="@"/>
	<c:choose>
		<c:when test="${empty titleList}">
			<tr>
				<td colspan="2">이 달의 영화가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="title" items="${titleList}">
		
				<c:forEach var="str" items="${sellStr}">
					<c:set var="test" value="${month}${title}${str}"/>
					<c:forEach var="map" items="${sellMap }">
						<c:if test="${test eq map.key}">
							<c:if test="${term ne title}">
							<tr>
								<th align="center" rowspan="3" class="m2" width="200">${title}</th>
							</tr>
							</c:if>
							<c:set var="k" value="${month}"/>
							<c:set var="term" value="${title}"/>
							<tr>
							<c:choose>
								<c:when test="${str eq 'MoviesAdult'}">
									<td align="right"><div align="left" style="width: 200;">성인</div>
								</c:when>
								<c:when test="${str eq 'MoviesStudent'}">
									<td align="right"><div align="left" style="width: 200;">학생</div>
								</c:when>
								<c:otherwise>
									<td align="right" colspan="2"><div align="left" style="width: 200;" class="m2">Total</div>
								</c:otherwise>
							</c:choose>
	
						&nbsp;&nbsp;&nbsp;${map.value}</td>
						</tr>
						</c:if>
					</c:forEach>	
				</c:forEach>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>	
<%-- <table width="90%">
<caption> 영화간 매출 그래프 </caption>
<tr><td align="center"  width="100%">

<div class="vGraph">
	<ul>
	<c:forEach var="movie" items="${moviemap }">
		<li><span class="gTerm">${movie.key } </span><span class="gBar" style="height: ${movie.value /2000}"><span>${movie.value} (원) </span></span></li>
	</c:forEach>
	</ul>
</div>
</td></tr>
</table> --%>
<!-- <button type="button" onclick="$('link').attr('href', '')">CSS(X)</button>
<button type="button" onclick="$('link').attr('href', 'vGraph.css')">CSS(O)</button> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> 

</div>

<%@ include file="../admin_bottom.jsp"%>