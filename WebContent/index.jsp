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
<style>
	*{margin:0;padding:0}
	ul,li{list-style:none}
	.rolling_wrap{width:980px;height:450px}
	
	#STATICMENU { margin: 0pt; padding: 0pt;  position: absolute; right: 0px; top: 0px;}
</style>
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
		
	  <table width="98%">
			<tr><td colspan="2" width="100%" height="100" align="left">
				<img src="img\main\main_selection.png">
			</td></tr>
			<tr><td width="70%" height="388">
				<embed src="img\main\miljung.mp4"
							quality="high" bgcolor="#ffffff" width="734" height="388"
	 						autostart="false"  loop="true"  type="video/mp4"
				pluginspage="http://www.macromedia.com/go/getflashplayer"></embed>
			</td>
			<td width="70%" height="388">
				<img src="poster\miljung.png">
			</td>
			</tr>
			<tr><td colspan="2" width="100%" height="100" align="left">
				<img src="img\main\main_event.png" alt="eventAlt"></td></tr>
			<tr><td height="200"></td></tr>
			<tr><td height="200"></td></tr>
		</table>
					<div id="STATICMENU">
				<img src="img\main\btn_banner.png">
			</div>
	</main>
<!-- 주석추가.한호 -->
<aside>
AD
</aside>
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
	 var stmnActivateSpeed = 35; //스크롤을 인식하는 딜레이 (숫자가 클수록 느리게 인식)
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