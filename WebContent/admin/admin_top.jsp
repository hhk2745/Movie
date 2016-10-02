<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- admin_top.jsp -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/testStyle.css">
<html>
<head>
<title>PROJECT</title>
<style type="text/css">
ul {
	list-style: none;
	font-weight: bold;
	font-size: 20px;
	display: table;
}

li {
	float: left;
	margin: 0px;
	padding: 0px;
	display: block;
}

a {
	text-decoration: none;
	color: inherit;
}
</style> 

<c:if test="${empty id }">
	<script type="text/javascript">
		alert("관리자용 페이지 입니다.");
		location.href ="index.do";
	
	</script>
</c:if>  



<c:if test="${not empty msg}">
	<script type="text/javascript">
		alert("${msg}");
		location.href = history.go(-1);
	</script>
</c:if>

<ul class="topBox">
	<a href="index.do"> 
		<img alt="" src="${pageContext.request.contextPath}/admin/img/cgv.png" height="60px">
	</a>
	
	<a href="admin_member.do">
		<li class="hover effect4"><span>회원관리</span></li>
	</a>
	<!-- admin/movie/admin_movie.jsp -->
	<a href="admin_movie.do">
		<li class="hover effect4"><span>영화관리</span></li>
	</a>
	<a href="admin_theater.do">
		<li class="hover effect4"><span>극장관리</span></li>
	</a>
	<a href="admin_sell_month.do">
		<li class="hover effect4"><span>매출관리</span></li>
	</a>
	<a href="admin_board.do">
		<li class="hover effect4"><span>게시판관리</span></li>
	</a>
</ul>
</head>
<body>