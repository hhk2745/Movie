<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<html>
<head>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.0.min.js" ></script>
	<script language="javascript" src="js/rolling.js"></script>
	<link rel="stylesheet" type="text/css" href="template.css">
	<!-- <link rel="stylesheet" type="text/css" href="css\template.css"> -->
	<script>
		$(document).ready(function() {
			 $('.rolling_wrap').rolling({
			arrowBtn:true,
			rollingBtn:true,
			main:true,
			timer:6000
			});
		});
	</script>
</head>

<body id="floating_banner" onload="InitializeStaticMenu();">
	<div>
		<table class="topmenu" width="98%">
		<tr align="right">
			<td>
				<!-- Mypage 링크 메뉴  -->
				<a href="member_MyPage.do?mode=myPageMain"><font size="2.5px" face="BareunDotum1">
				MyPage &nbsp;</a>
				<!-- 회원가입 링크 메뉴  -->
				<a href="member_JoinCheck.do"><font size="2.5px" face="BareunDotum1"> 
				회원가입 &nbsp;</a>			
				<!-- 로그인 링크 메뉴  -->
				<c:if test='${empty loginId}'> 
					<a href="member_Login.do"><font size="2.5px" face="BareunDotum1">
					로그인 &nbsp;</font></a>
				</c:if>
				
				<!-- 로그아웃 링크 메뉴  -->
				<c:if test='${!empty loginId}'>
					<a href="member_Logout.do"><font size="2.5px" face="BareunDotum1">
					로그아웃 &nbsp;</font></a>
				</c:if>
						&nbsp;&nbsp; <!-- 메뉴 간격 가독성을 위한 공백 -->
			</td>
		</tr>
		</table>
		
		<table width="98%" height="119px" align="center" background="img\main\bg_header.png">
		<tr>
			<td width="15%" height="119px" align = "right" >
				<!-- 메뉴 가독성을 위한 빈 테이블 (좌측 레이아웃 부분) -->
			</td>
			<td width="10%" height="119px" align = "right" >	
				<a href="index.do"><img src="img\main\main_logo.png"></a>
			</td>
			<td width="60%" align="center" cellpadding="100px">
				<img src="img\main\main_cultureplex.png"><br>
				
				<!-- 영화 메뉴  -->
				<a href="client_movie_all.do" valign="bottom"><font size="5px">
				영화</a>	
				
				<!-- 예매 메뉴  -->			
				<c:forEach begin="1" end="20" step="1">&nbsp;</c:forEach>
				<a href="client_movieReserve.do" valign="bottom"><font size="5px">
				예매</a>	
				
				<!-- 극장 메뉴  -->		
				<c:forEach begin="1" end="20" step="1">&nbsp;</c:forEach>
				<a href="#" valign="bottom"><font size="5px">
				극장</a>
				
				&nbsp;&nbsp;&nbsp;&nbsp; <!-- 메뉴 간격 가독성을 위한 공백 -->
				
			 </td>
				
		  <td width="15%" height="119px" align = "right" >
		  		<!-- 메뉴 사이즈를 맞추기 위한 빈 테이블 (좌측 빈 레이아웃 부분) -->
		  </td>
		</tr>
		</table>
	</div>