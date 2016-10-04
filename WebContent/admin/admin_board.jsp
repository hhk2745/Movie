<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- admin_board.jsp -->
<%@ include file="admin_top.jsp"%>
<ul class="submenuBox">
	<a href="admin_faqboard_list.do?mode=전체">
		<li class="subHover effect"><span>자주 찾는 질문</span></li>
	</a>
	<a href="admin_qnaboard_list.do">
		<li class="subHover effect"><span>1:1 문의</span></li>
	</a>
	<a href="admin_fileboard_list.do">
		<li class="subHover effect"><span>File게시판</span></li>
	</a>
	<a href="admin_category_list.do">
		<li class="subHover effect"><span>카테고리 관리</span></li>
	</a>
</ul>
<%@ include file="admin_bottom.jsp"%>