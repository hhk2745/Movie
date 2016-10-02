<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>
<script type="text/javascript">
	var offset=location.href.indexOf(location.host)+location.host.length;
	var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
		function change1(obj){
			obj.style.width = "570px";
			obj.style.height="430px";
			obj.style.backgroundImage="url("+ctxPath+"/img/theater/GangNam.png)";
		}
		function change2(obj){
			obj.style.width = "570px";
			obj.style.height="430px";
			obj.style.backgroundImage="url("+ctxPath+"/img/theater/Jong.png)";
		}
		function change3(obj){
			obj.style.width = "570px";
			obj.style.height="430px";
			obj.style.backgroundImage="url("+ctxPath+"/img/theater/GangByeon.png)";
		}
		function change4(obj){
			obj.style.width = "570px";
			obj.style.height="430px";
			obj.style.backgroundImage="url("+ctxPath+"/img/theater/SongPa.png)";
		}
		
</script> 
<c:if test="${empty loginId}">
   <script type="text/javascript">
      alert('로그인 후 사용가능한 페이지입니다.');
      location.href="member_Login.do";
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

	<main> <!-- 극장 선택 페이지   /  상영극장은 1개이므로 실행되는것은 하나만  -->

	<style>
		ul {
			list-style: none;
		}
	</style>

	<div style="padding-left: 40px; padding-top: 60px; padding-right:40px;" >
		<font style="font-family: 'Times New Roman'; font-size: 30px; font-weight: bold;"  > T h e a t e r  </font><br><br>
		<br><br>
		<hr><br><br>
		<table width="900px" style="min-height : 400px">
			<tr>
				<td align="center" style="min-height:400px;">
					
						<a href="client_ticketReserve.do?theater=1&num=${num}" onmouseenter="change1(theaterImage)">강남</a><p>
						<a href="" onmouseenter="change2(theaterImage)">종로 (오픈 준비중)</a><p>
						<a href="" onmouseenter="change3(theaterImage)">강변 (오픈 준비중)</a><p>
						<a href="" onmouseenter="change4(theaterImage)">송파 (오픈 준비중)</a>
					
				</td>
				<td align="center" width="570px" height="430px" id="theaterImage" > 
					<font style="color:#DCDCDC; font-weight: bold; font-size: 60px; font-family: 'Times New Roman'">C   G   V</font>
				</td>
				
			</tr>
		</table>
	</div>
	
	<div align="right" style="padding-right: 80px; padding-top: 40px">
		<%-- <a href="client_ticketReserve.do?num=${num }">선택완료</a> --%>
	</div>


	</main>
	<aside>aside</aside>
</section>
<%@ include file="../../bottom.jsp"%>