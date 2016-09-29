<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<%@ include file="../admin_top.jsp"%>

	<table border="1" width="100%">
	<tr>
		<td colspan="2">
			<div align="center">
				<b>일반 게시판</b>
				<table width="90%" class="ex1">
				</table>
			</div>
		</td>
	</tr>
	
	<c:choose>
		<c:when test="${empty boardList}">
			<tr>
				<th align="center" colspan="5">등록된 게시글이 없습니다.</th>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
			<c:set var="count" value="0"/>
				<c:forEach var="dto" items="${boardList}">
				<c:set var="count" value="${count+1}" />
				<td align="center">
					<table border="1" width="30%" height="30%">
						<tr>
							<td width="10">
								<img src="img/logo.png" width="60" height="60">
							</td>
							<th align="center" valign="top">${dto.id}</th>
								<td align="center">
									<input type="button" style="width:70pt;height:30pt;" 
									value="&nbsp;&nbsp;&nbsp;삭제&nbsp;&nbsp;&nbsp;"
									onclick="window.location='admin_fileboard_delete.do?num=${dto.num}&id=${dto.id}&fileName=${dto.fileName}'">
								</td>
						</tr>
						<tr>
							<td align="center" colspan="3">
								${dto.content}
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<img src="${upPath}${dto.fileName}">
								<%-- <c:out value="${upPath}${dto.fileName}"></c:out> --%>
								<%-- <c:out value="${upPath}${dto.fileName}"></c:out> --%>
								<%-- "${pageContext.request.contextPath}/img/sitImg/out.png" --%>
								<%-- <c:out value="${pageContext.request.contextPath}"></c:out> --%>
								<%-- <img src="${imgUpPath}${dto.fileName}"> --%>
								<%-- <img src="<img src="<c:url value="/images/tomcat.gif"/>">"> --%>
								<%-- <img src="${pageContext.request.contextPath}"> --%>
								<%-- <img src="<c:url value='/WebContent/WEB-INF/customer/fileboard/files/ony.PNG'/>"> --%>
								<%-- <c:out value="${pageContext.request.contextPath}/WebContent/WEB-INF/customer/fileboard/files/ony.PNG"></c:out> --%>
							</td>
						</tr>
					</table>
				</td>
				<c:if test="${count%2==0}">
					</tr><tr>
				</c:if>
				</c:forEach>
			</tr>
		</c:otherwise>
	</c:choose>
	</table>
		<div align="center">
			<c:set var="pageCount" value="${pageCount}" />
			<c:set var="pageBlock" value="${pageBlock}" />
			<c:set var="startPage" value="${startPage}" />
			<c:set var="endPage" value="${endPage}" />
			<c:if test="${count > 0}">
				<c:if test="${endPage > pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>
				<c:if test="${startPage > pageBlock}">
					[<a href="admin_fileboard_list.do?pageNum=${startPage-pageBlock}">이전</a>]
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					[<a href="admin_fileboard_list.do?pageNum=${i}">${i}</a>]
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					[<a href="admin_fileboard_list.do?pageNum=${startPage+pageBlock}">다음</a>]
				</c:if>
			</c:if>
		</div>

<%@ include file="../admin_bottom.jsp"%>