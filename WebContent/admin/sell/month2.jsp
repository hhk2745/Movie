<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../admin_top.jsp"%>
<link rel="stylesheet" type="text/css" href="vGraph.css"/>


<div align="center">
	<ul class="submenuBox">

		<li class="subHover effect"><span><a>매출리스트</a></span></li>

		<li class="subHover effect"><span><a>+</a></span></li>

	</ul>
</div>
<div class="vGraph">
	<ul>
		<li><span class="gTerm">SUN</span><span class="gBar" style="height:0%"><span>0%</span></span></li>
		<li><span class="gTerm">MON</span><span class="gBar" style="height:20%"><span>20%</span></span></li>
		<li><span class="gTerm">TUE</span><span class="gBar" style="height:30%"><span>30%</span></span></li>
		<li><span class="gTerm">WED</span><span class="gBar" style="height:40%"><span>40%</span></span></li>
		<li><span class="gTerm">THU</span><span class="gBar" style="height:50%"><span>50%</span></span></li>
		<li><span class="gTerm">FRI</span><span class="gBar" style="height:60%"><span>60%</span></span></li>
		<li><span class="gTerm">SAT</span><span class="gBar" style="height:100%"><span>100%</span></span></li>
	</ul>
</div>
<!-- <button type="button" onclick="$('link').attr('href', '')">CSS(X)</button>
<button type="button" onclick="$('link').attr('href', 'vGraph.css')">CSS(O)</button> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> 

test 01 

<%@ include file="../admin_bottom.jsp"%>