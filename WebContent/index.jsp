<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="top.jsp"%>
<!-- 주석추가 -->
<!-- 주석추가.진철2 -->
<c:if test="${!empty memberCheck && memberCheck eq false}">
	<script type="text/javascript">
		alert("이미 가입된 회원입니다. 로그인 해주세요.");
	</script>
</c:if>

<c:if test="${!empty insertResult && insertResult eq false}">
	<script type="text/javascript">
		alert("회원가입 실패!");
		
	</script>
</c:if>
<c:if test="${!empty insertResult && insertResult eq true}">
	<script type="text/javascript">
		alert("회원가입을 축하드립니다! 로그인 해 주세요.");
	</script>
</c:if>
<!-- 주석추가. -->

<c:if test="${!empty loginId && loginId.confirm ne 'ok'}">
	<script type="text/javascript">
		alert("인증되지 않은 회원입니다. 인증화면으로 이동합니다.");
		var myWindow = window.open('confirm.do','',"left=400, top=100, width=880,height=650");
		
		/* myWindow.document.write("<p>This window's name is: " + myWindow.name + "</p>"); */
		
	</script>
</c:if>
<c:if test="${!empty msg}">
   <script type="text/javascript">
   alert("${msg}");
   </script>
</c:if>

<section class="content">
	<nav>
		<ul>
			<li>html</li>
			<li>css</li>
			<li>javascript</li>
		</ul>
	</nav>
<!-- 주석추가.한호 -->
	<main> test 양전모 is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu
	Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is
	Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name
	is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog
	name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu
	Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim
	Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu
	Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu
	Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is
	Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name
	is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog
	name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu
	Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim
	Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu
	Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu
	Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is
	Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name
	is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog
	name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu
	Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim
	Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu
	Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu
	Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is
	Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name
	is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog
	name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu
	Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim
	Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu
	Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu
	Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is
	Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name
	is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog
	name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu
	Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim
	Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu
	Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu
	Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is
	Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name
	is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog
	name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu
	Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim
	Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu
	Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu
	Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is
	Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name
	is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog
	name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu
	Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim
	Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu
	Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu
	Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is
	Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name
	is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu Dog
	name is Bok-Gu Bok-Gu Kim Bok-Gu Dog name is Bok-Gu Bok-Gu Kim Bok-Gu </main>
<!-- 주석추가.한호 -->
<aside>
AD
</aside>
</section>
<!-- 주석추가.한호2 -->
<%@ include file="bottom.jsp"%>