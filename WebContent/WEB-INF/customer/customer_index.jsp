<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../top.jsp"%>

<script type="text/javascript">
	function checkSearch(){
		if (f.search.value == "" || f.search.value == "검색어를 입력해 주세요."){
			alert("검색어를 입력해 주세요.");
			f.search.focus();
			return false;
		}
		return true;
	}
</script>

<script type="text/javascript"> 
function a(search){ 
   if (search.defaultValue == search.value) {
	   search.value = "";
   }
}
</script>
 
<section class="content">
	<nav>
		<ul>
			<li style="margin-left: 50px; margin-bottom: 10px;  background-color: rgb(231, 26, 15);"><a href="customer_main.do" style="color: white;">고객센터 메인</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="qna_writeForm.do">1:1 문의하기</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="faqboard_list.do?mode=전체">자주 찾는 질문</a></li>
			<li style="margin-left: 50px; margin-bottom: 10px;"><a href="fileboard_setting.do">FILE(자료실형)</a></li>
		</ul>
	</nav>
	<main>
		<form name="f" action="faq_search.do" method="post" onsubmit="return checkSearch()">
			<table width="99%">
				<tr>
					<td align="center" width="33%">
						<table width="100%" height="405px" align="center" background="img/faq_search.PNG">
							<tr>
								<td align="center">
									<br><br><br><br><br><br>
									<b><font size="6" color="white">자주찾는 질문 빠른검색</font></b><p>
									<input type="text" name="search" size="30" value="검색어를 입력해 주세요." onFocus="a(this);">
									<input type="submit" value="검색"><p>
									<b><font size="3" color="white">| 추천 검색어 | 영화    예매    회원가입</font></b><p>
								</td>
							</tr>
						</table>
					</td>
					<!--  -->
					<td align="center" width="33%">
						<table>
							<tr>
								<td>
									<a href="qna_writeForm.do">
										<img src="img/qna_write.PNG">
									</a>
								</td>
							</tr>
						</table>
					</td>
					<!--  -->
					<td align="center" width="33%">
						<table>
							<tr>
								<td>
									<a href="qnaboard_list.do?id=${loginId.id}">
										<img src="img/qna_list.PNG">
									</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</main>
</section>

<%@ include file="../../../bottom.jsp"%>