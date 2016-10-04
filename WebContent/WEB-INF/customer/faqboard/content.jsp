<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../top.jsp"%>

<c:if test="${!empty result && result eq true}">
	<script>
		window.open("faq_imgOpen.do?fileName=${fileName}", "", "width=1000, height=500, left=100, top=100"); 
	</script>
</c:if>

<section class="content">
	<nav>
		<ul>
         <li><a href="customer_main.do">고객센터 메인</a></li>
         <li><a href="qna_writeForm.do">1:1 문의하기</a></li>
         <li><a href="faqboard_list.do?mode=전체">자주 찾는 질문</a></li>
         <li><a href="fileboard_setting.do">FILE(자료실형)</a></li>
      </ul>
	</nav>
	<main>
	<div align="center">
	<b>질문 내용 보기</b>
	<table border="1" width="600">
		<tr>
			<th bgcolor="yellow">구분</th>
			<td align="center">[ ${boardDTO.category_title} ]</td>
			<th bgcolor="yellow">조회수</th>
			<td align="center">${boardDTO.readCount}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">제목</th>
			<td align="center" colspan="3">${boardDTO.title}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">내용</th>
			<td align="center" colspan="3">${boardDTO.content}</td>
		</tr>
		<tr>
			<th bgcolor="yellow">첨부 이미지</th>
			<td colspan="3" align="center">
				<c:choose>
					<c:when test="${boardDTO.fileName eq null}">
						<img src="img/null_img.gif">
					</c:when>
					<c:otherwise>
						<a href="faq_img.do?fileName=${boardDTO.fileName}&num=${boardDTO.num}">
							<img src="<c:url value="admin_faqboard_files/${boardDTO.fileName}"/>" width="150" height="150">
						</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td bgcolor="yellow" align="right" colspan="4">
				<c:choose>
					<c:when test="${search eq null}">
						<input type="button" value="목록보기" onClick="window.location='faqboard_list.do?mode=전체'">
					</c:when>
					<c:otherwise>
						<input type="button" value="목록보기" onClick="window.location='faq_search.do?search=${search}'">
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	</div>
	</main>
</section>

<%@ include file="../../../bottom.jsp"%>