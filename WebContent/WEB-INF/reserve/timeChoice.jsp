<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<section class="content">
	<nav>
		<ul>
			<li>html</li>
			<li>css</li>
			<li>javascript</li>
		</ul>
	</nav>

	<main> <!-- 영화,상영극장 정보를 가지고 스케쥴 검색해서 	날짜, 시간, 영화제목, 상영관, 총좌석(남은좌석) 뿌려주기 // 위쪽에 예매할 표 갯수 선택 가능하게  -->
	<div style="padding: 40px;">
	<font style="font-family: 'Times New Roman'; font-size: 30px; font-weight: bold;"  >Select - Time</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;강남점</font><p></div>
	<hr />
	<p style="line-height: 280px">
	<div style="padding-left: 40px; padding-top: 60px">
		<table align="center" style="min-width: 900px">
		<tr><td align="center"> 영 화 </td> <td align="center"> 날짜 </td> <td align="center"> 상영관  </td> <td align="center"> 시간대 (좌석)</td> 
			<tr>
				<td  align="center" width="20%" rowspan="${fn:length(scheduleList)}"> <c:set var="title" value="${scheduleList[0].title}" /> ${title } </td>
				<c:forEach var="dto" items="${scheduleList }">
				<c:choose>
				<c:when test="${dto.sitCount ==0 }"> </c:when>
				<c:otherwise>
					<td  align="center" width="20%"><br> ${dto.day } <br></td>
					<td  align="center" width="20%"><br>${dto.theaternum } 관 <br></td>
					<td  align="center" width="40%"><br>
					<a href="client_chairReserve.do?time=${dto.time }&num=${num}&theater=${theater}&day=${dto.day}&theaternum=${dto.theaternum}" > ${dto.time }  
					<font style="font-size: 12px"> ( 전체  : 56 석 / 남은 좌석 : ${dto.sitCount} 석 )</font></a>
					<br>
					</td>
			</tr>
			<tr> 
					</c:otherwise>
				</c:choose>
				</c:forEach>
			</tr>
		</table>
		<p style="line-height: 280px">
		<div align="right" style="padding-right: 80px">
			<!-- <a href="client_chairReserve.do">선택완료</a> -->
		</div>
	</div>
	</main>
	<aside>aside</aside>
</section>
<%@ include file="../../bottom.jsp"%>