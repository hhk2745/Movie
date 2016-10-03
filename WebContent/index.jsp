<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="top.jsp"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.0.min.js" ></script>
<script language="javascript" src="js\rolling.js"></script>
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
<c:if test="${!empty loginId && loginId.confirm ne 'ok'}">
	<script type="text/javascript">
		alert("인증되지 않은 회원입니다. 인증화면으로 이동합니다.");
		var myWindow = window.open('confirm.do','',"left=400, top=100, width=880,height=650");
	</script>
</c:if>
<c:if test="${not empty msg}">
	<script type="text/javascript">
	alert('${msg}');	
	</script>
</c:if>
<c:if test="${!empty dropOutResult && dropOutResult eq true}">
	<script type="text/javascript">
		alert('그동안 이용해주셔서 감사합니다.');
	</script>
</c:if>
<c:if test="${!empty memberInfoUpdateResult && memberInfoUpdateResult eq true}">
	<script type="text/javascript">
		alert('회원정보가 수정되었습니다. 다시 로그인 해주세요.');
	</script>
</c:if>
<section class="content">
<nav></nav>
	
<!-- 주석추가.한호 -->
	<main> 
		<ul class="rolling_wrap">
			<li><img src="img\main\banner_main1.png"></li>
			<li><img src="img\main\banner_main2.png"></li>
			<li><img src="img\main\banner_main3.png"></li>
			<li><img src="img\main\banner_main4.png"></li>
			<li><img src="img\main\banner_main5.png"></li>			
		</ul>
		<ul>
			<li><img src="img\main\main_selection.png"></li>
			<li><embed src="img\main\miljung.mp4"
							quality="high" bgcolor="#ffffff" width="734" height="388"
	 						autostart="false"  loop="true"  type="video/mp4"
				pluginspage="http://www.macromedia.com/go/getflashplayer"></embed><img src="poster\miljung.png"></li>
		</ul>
		
		<ul>
			<li><img src="img\main\main_event.png" alt="eventAlt"></li>
			<li><img src="img\main\event0.jpg" height="200px;"><img src="img\main\event2.jpg"><img src="img\main\event3.jpg"><img src="img\main\event4.png"></li>
			<li style="padding-left:20px;"><img src="img\main\event5.png"><img src="img\main\event6.jpg" style="margin-left: 20px;"><img src="img\main\event7.png" style="width:228px;"></li>
		</ul>
			<div id="STATICMENU">
				<img src="img\main\btn_banner.png">
			</div>
	</main>
<!-- 주석추가.한호 -->
</section>
<!-- 주석추가.한호2 -->

<script>
		$(document).ready(function() {
		    $('.rolling_wrap').rolling({
				arrowBtn:true,
				rollingBtn:true,
				main:true,
				timer:6000
			});
		});
</script>
<script type="text/javascript">
	 var stmnLEFT = 10; // 오른쪽 여백 
	 var stmnGAP1 = 0; // 위쪽 여백 
	 var stmnGAP2 = 150; // 스크롤시 브라우저 위쪽과 떨어지는 거리 
	 var stmnBASE = 150; // 스크롤 시작위치 
	 var stmnActivateSpeed = 15; //스크롤을 인식하는 딜레이 (숫자가 클수록 느리게 인식)
	 var stmnScrollSpeed = 20; //스크롤 속도 (클수록 느림)
	 var stmnTimer; 
	 
	 function RefreshStaticMenu() { 
	  var stmnStartPoint, stmnEndPoint; 
	  stmnStartPoint = parseInt(document.getElementById('STATICMENU').style.top, 10); 
	  stmnEndPoint = Math.max(document.documentElement.scrollTop, document.body.scrollTop) + stmnGAP2; 
	  if (stmnEndPoint < stmnGAP1) stmnEndPoint = stmnGAP1; 
	  if (stmnStartPoint != stmnEndPoint) { 
	   stmnScrollAmount = Math.ceil( Math.abs( stmnEndPoint - stmnStartPoint ) / 15 ); 
	   document.getElementById('STATICMENU').style.top = parseInt(document.getElementById('STATICMENU').style.top, 10) + ( ( stmnEndPoint<stmnStartPoint ) ? -stmnScrollAmount : stmnScrollAmount ) + 'px'; 
	   stmnRefreshTimer = stmnScrollSpeed; 
	   }
	  stmnTimer = setTimeout("RefreshStaticMenu();", stmnActivateSpeed); 
	  } 
	 function InitializeStaticMenu() {
	  document.getElementById('STATICMENU').style.rignt = stmnLEFT + 'px';  //처음에 오른쪽에 위치. left로 바꿔도.
	  document.getElementById('STATICMENU').style.top = document.body.scrollTop + stmnBASE + 'px'; 
	  RefreshStaticMenu();
	  }
	</script>
<%@ include file="bottom.jsp"%>