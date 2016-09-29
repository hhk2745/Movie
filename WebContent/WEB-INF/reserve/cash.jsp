<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>

<!-- <style type="text/css">
hr {
	border-top: 2px solid #9C9C9C;
	border-bottom: 3px solid #F6F6F6;
}
</style> -->
<!-- <script type="text/javascript">
	function usingPoint() {
		if(f.point.value >5000){
			alert('사용 가능 마일리지 초과')
			return;
		} 
		document.f.submit();
		
	}

</script>
 -->
<script type="text/javascript">
	function cash() {
		
		
		
		document.f.action="client_reserve_success.do";
		document.f.method="post";
		document.f.submit();
		
	}

</script>
 
<section class="content">
	<nav>
		<ul>
			<li>html</li>
			<li>css</li>
			<li>javascript</li>
		</ul>
	</nav>
	 <!--  결제 페이지 / 총 얼마  현금얼마 포인트 얼마    결제하기  누르면  예매테이블로 -->
<main>
	<div style="padding-left: 50px; padding-right: 50px; padding-top: 50px; ">
		<font style="font-family: 'Times New Roman'; font-size: 30px; font-weight: bold;"  >Reserve Page</font><br><br>
		<hr />
		<br> <br> <br> <br> <br>
		
		<!-- 값 넣기 -->
		<p style="line-height: 20px" />
		<!-- <form name="f"> 
		<h4>	포인트 사용 : <input type="text" name="point">  (사용가능 포인트 : 5000p) </h4>  
		<br><button type="button" onclick="javascript:usingPoint()"> 사용하기 </button> </form>
		<p style="line-height: 200px" /> -->
		
		<div style="padding-left: 20px; font-size: 15px; font-family: 'Times New Roman';">
			<c:set var="title" value="${ticketChkdto.title }"/> ${title } &nbsp;&nbsp;&nbsp;&nbsp; <br>
			<c:set var="theater" value="${ticketChkdto.theater }"/> ${theater }  &nbsp;&nbsp;&nbsp;&nbsp;
			<c:set var="theaternum" value="${ticketChkdto.theaternum }"/> ${theaternum } 번 상영관 &nbsp;&nbsp;&nbsp;&nbsp;
			<c:set var="day" value="${ticketChkdto.day }"/> ${day }   &nbsp;&nbsp;&nbsp;&nbsp;
			<c:set var="time" value="${ticketChkdto.time }"/> ${time }  &nbsp;&nbsp;&nbsp;&nbsp;
			<c:set var="count" value="${count }"/>  ${count } 장 선택    &nbsp;&nbsp;&nbsp;&nbsp;
			<c:set var="sitnum" value="${ticketChkdto.sitnum }"/> 좌석 :  ${sitnum }   	<br><br><br><br>			
			<c:set var="id" value="${ticketChkdto.id }"/>
			 <div  style="padding-right: 60px;" align="right"> 구매자  : ${id}( ${name } )  &nbsp;&nbsp;&nbsp;&nbsp;	
		</div>
		<div style="padding-right: 60px; padding-top: 120px" align="right">
		<h2>결제 금액 : <c:set var = "total" value="${ticketChkdto.price }" /> ${total } (원) </h2></div>
		<br>
		<br>
		<br>
		<hr />
		<br><br>
		<form name="f">
		<input type="hidden" name="title" value="${title }">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="theater" value="${theater }">
		<input type="hidden" name="theaternum" value="${theaternum }">
		<input type="hidden" name="time" value="${time }" >
		<input type="hidden" name="day" value="${day }" >
		<input type="hidden" name="count" value="${count }">
		<input type="hidden" name="adultCount" value="${adultCount }">
		<input type="hidden" name="childCount" value="${childCount }">
		<input type="hidden" name="sit" value="${sitnum }" >
		</form>
		<div style="padding-right: 90px;" align="right">
			<a href="javascript:cash()"><font style="font-size: 25px;"> 예약하기</font></a>
		</div>
	</div>
</main>	
<aside>aside</aside>
</section>
<%@ include file="../../bottom.jsp"%>