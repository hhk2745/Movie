<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin_top.jsp"%>
<link rel="stylesheet" type="text/css" href="admin/sell/vGraph.css"/>


<div align="center">
	<ul class="submenuBox">

		<li class="subHover effect"><span><a href="<%=request.getContextPath()%>/admin_sell_year.do">연간 매출</a></span></li>

		<li class="subHover effect"><span><a href="<%=request.getContextPath()%>/admin_sell_movie.do">영화간 매출 </a></span></li>

	</ul>
<table width="90%">
<caption> 월간 매출 그래프 </caption>
<tr><td align="center" width="100%">

<div class="vGraph">
	<ul>
	<c:forEach var="month" items="${monthmap }">
		<li><span class="gTerm">${month.key } 월</span><span class="gBar" style="height: ${(month.value /100)}"><span>${month.value} (원) </span></span></li>
	</c:forEach>
	</ul>
</div>
</td></tr>
</table>
<!-- <button type="button" onclick="$('link').attr('href', '')">CSS(X)</button>
<button type="button" onclick="$('link').attr('href', 'vGraph.css')">CSS(O)</button> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> 

</div>

<%@ include file="../admin_bottom.jsp"%>