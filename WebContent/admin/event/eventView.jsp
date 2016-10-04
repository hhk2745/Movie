<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../admin_top.jsp"%>

<c:if test="${empty dto}">
이벤트정보를 불러올 수 없습니다.
</c:if>
<c:if test="${!empty dto}">

</c:if>
<%@ include file="../admin_bottom.jsp"%>