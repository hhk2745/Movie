<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!-- admin_movie_update.jsp -->
<%@ include file = "../admin_top.jsp"%>
<div align="center">
	<ul class="submenuBox">
		<a href="admin_theater.do">
			<li class="subHover effect">
				<span>스케줄리스트</span>
			</li>
		</a>
		<a href="admin_theater_isNull.do">
			<li class="subHover effect">
				<span>등록안된 스케줄 목록</span>
			</li>
		</a>
		<a>
			<li class="subHover effect">
				<span>+</span>
			</li>
		</a>
	</ul>
	<hr color="Green" width="99%">
	<h2>스케줄관리</h2>
	<hr color="Green" width="99%">
	<table border="center" width="99%">
		<tr>
			<td align="center" bgcolor="#ffdab9">상영관</td>
			<td align="center" bgcolor="#ffdab9">상영날짜</td>
			<td align="center" bgcolor="#ffdab9">상영시간</td>
			<td align="center" bgcolor="#ffdab9">상영영화</td>
		</tr>
		<c:if test="${empty theaterList}">
			<tr>
				<td colspan="5">등록된 스케줄이 없습니다.</td>
			</tr>
		</c:if>
		
		
		<c:set var="count" value="0"/>
		<c:forEach var="theaterDTO" items="${theaterList}">
			<c:if test="${count==0}">
				<h4>서울_강남</h4>
			</c:if>
			<tr>
				<%-- <c:choose>
					<c:when test="${not empty nullMap}">
						<td align="center" rowspan="${nullMap.value}">${theaterDTO.theaternum}</td>
					</c:when>
					<c:otherwise> --%>
				<c:if test="${count%25==0.0}">
					<td align="center" rowspan="${theaternumsize}">${theaterDTO.theaternum}</td>		<!-- 리스트 계산 -->
				</c:if>
					<%-- </c:otherwise>
				</c:choose> --%>
				
				<c:if test="${count%5==0.0}">
					<td align="center"  rowspan="5">${theaterDTO.day}</td>
				</c:if>
				<c:forEach var="timeDTO" items="${timeList}">
					<c:if test="${theaterDTO.time==timeDTO.num}">
						<td align="center">${timeDTO.time}</td>
					</c:if>
				</c:forEach>
				
				<td align="center">
					<a href="admin_theater_update.do?theater=${theaterDTO.theater}&
							theaternum=${theaterDTO.theaternum}&day=${theaterDTO.day}&
							time=${theaterDTO.time}"><c:if test="${empty theaterDTO.title}">없음</c:if>${theaterDTO.title}</a>	<!-- 업데이트 처리 -->
				</td>
			</tr>
			<c:set var="count" value="${count+1}"/>
		</c:forEach>
		
	</table>
</div>
<%@ include file = "../admin_bottom.jsp"%>