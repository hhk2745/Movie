<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- admin_movie_insertForm.jsp -->
<%@ include file = "../admin_top.jsp"%>
<div align="center">
	<ul class="submenuBox">
		<a href="admin_theater.do">
			<li class="subHover effect">
				<span>상영 일정 현황</span>	
			</li>	
		</a>
		<a href="admin_theater_isNull.do">
			<li class="subHover effect">
				<span>상영 일정 추가</span>
			</li>		
		</a>
	<!-- 	<a>
			<li class="subHover effect">
				<span>+</span>
			</li>
		</a>	 -->	
	</ul>
	<hr color="Green" width="99%">
	<h4>영화 상영 일정 수정 </h4>
	<hr color="Green" width="99%">
	<form action="admin_theater_update.do" name="f" method="post">
	<table border="center" width="99%">
		<tr>
			<td align="center" width="30%" bgcolor="#ffdab9">제목</td>
			<td width="70%"> 
				<select name="title">
				<c:forEach var="dto" items="${movieTitleList}">
					<c:choose>
						<c:when test="${scheduleDTO.title eq dto.title}">
							<option value="${dto.title}" selected="selected">${dto.title}</option>
						</c:when>
						<c:otherwise>
							<option value="${dto.title}">${dto.title}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
		</tr>
		<tr>
			<td align="center" width="30%" bgcolor="#ffdab9">시간</td>
			<td width="70%">
				<input type="hidden" name="time" value="${scheduleDTO.time}">
				${scheduleTime}
			</td>
		</tr>
		<tr>
			<td align="center" width="30%" bgcolor="#ffdab9">상영 지점</td>
			<td width="70%">
				<input type="hidden" name="theater" value="${scheduleDTO.theater}">
				${scheduleDTO.theater}
			</td>
		</tr>
		<tr>
			<td align="center" width="30%" bgcolor="#ffdab9">상영관</td>
			<td width="70%">
				<input type="hidden" name="theaternum" value="${scheduleDTO.theaternum}">
				${scheduleDTO.theaternum}
			</td>
		</tr>
		<tr>
			<td align="center" width="30%" bgcolor="#ffdab9">상영 날짜</td>
			<td width="70%">
				<input type="hidden" name="day" value="${scheduleDTO.day}">
				${scheduleDTO.day}
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2" bgcolor="#ffdab9">
				<button type="submit" value="수정" width="10%" >수정</button> 
				<button type="reset" value="reset" width="10%"> reset </button>
				<button type="button" value="뒤로" width="10%" onclick="javascript:history.go(-1)">
				뒤로 가기 </button>
			</td>
		</tr>
	</table>
	</form>
</div>
<%@ include file = "../admin_bottom.jsp"%>