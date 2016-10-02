<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css"/>


<div align="center">
	<ul class="submenuBox">

		<li ></li>
	</ul>
</div>

<div align="center">
<c:set var="k" value="0"/>
<table border="1" width="800">
<tr align="left" class="m2" height="50">
	<th colspan="2"><font size="5" style="font-weight: bold;">&nbsp;&nbsp;&nbsp;${year}년 매출정보</font></th>
</tr>
<c:forEach var="i" begin="1" end="${month}" step="1">
<c:forEach var="str" items="${sellStr}">
	<%-- ${str}<br> --%>
	<c:forEach var="maps" items="${sellMap}">
			<c:set var="test" value="${i}${str}"/>
			<c:if test="${test eq maps.key}">
				<c:if test="${k!=i}">
					<tr>
						<th align="center" rowspan="3" class="m2" width="200"><a href="admin_sell_movie.do?month=${i}">${i}월</a></th>
					</tr> 
				</c:if>
				<c:set var="k" value="${i}"/>
				<tr>
				<c:choose>
					<c:when test="${str eq 'Adult'}">
						<td align="right"><div align="left" style="width: 200;">성인</div>
					</c:when>
					<c:when test="${str eq 'Student'}">
						<td align="right"><div align="left" style="width: 200;">학생</div>
					</c:when>
					<c:otherwise>
						<td align="right" colspan="2"><div align="left" style="width: 200;"  class="m2">Total</div>
					</c:otherwise>
				</c:choose>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${maps.value}</td>
				</tr>
			</c:if>
		</c:forEach>
	</c:forEach>
</c:forEach>
</table>
</div>
<!-- <button type="button" onclick="$('link').attr('href', '')">CSS(X)</button>
<button type="button" onclick="$('link').attr('href', 'vGraph.css')">CSS(O)</button> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> 


<%@ include file="../admin_bottom.jsp"%>