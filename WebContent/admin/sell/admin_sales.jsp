<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- admin_sales.jsp -->
<%@ include file= "../admin_top.jsp" %>


<table width="80%" height="800px" align="center">
<tr>
	<td align="center"> <a href="<%=request.getContextPath()%>/admin_sell_month.do">월간매출</a> </td>
	<td align="center"> <a href="<%=request.getContextPath()%>/admin_sell_year.do">년간매출</a> </td>
</tr>
<tr>
	<td colspan="2" align="center"> <a href="<%=request.getContextPath()%>/admin_sell_movie.do">영화간 매출</a> </td>
</tr>
</table>

<%@ include file = "../admin_bottom.jsp" %>
