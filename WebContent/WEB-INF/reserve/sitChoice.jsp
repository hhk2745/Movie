<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp"%>

<!-- <style type="text/css">
hr {
	border-top: 2px solid #9C9C9C;
	border-bottom: 4px solid #F6F6F6;
}
</style> -->
<c:if test="${!empty msg}">
	<script type="text/javascript">
		var msg = '${msg}';
		alert(msg);
		location.href="index.do";
		</script>
</c:if>
<c:if test="${empty loginId}">
	<script type="text/javascript">
		alert('로그인 후 예매 가능합니다')
		location.href = "member_Login.do";
	</script>
</c:if>

<script type="text/javascript">
	function sitCheck() {
		var a = Number(f.adultCount.value); // 어른 표수 select
		var c = Number(f.childCount.value); // 청소년 표수 select

		var chk = document.getElementsByName("sitChoice");
		var len = chk.length
		var checkRow = ''; //체크된 체크박스의 value를 담기위한 변수
		var checkLast = '';
		var checkCnt = 0; //체크된 체크박스의 개수
		var rowid = ''; //체크된 체크박스의 모든 value 값을 담는다
		var cnt = 0;

		for (var m = 0; m < len; m++) {
			if (chk[m].checked == true) {
				checkCnt++; //체크된 체크박스의 개수
				checkLast = m;
			}
		}

		var chkCnt = Number(checkCnt);

		for (var n = 0; n < len; n++) {
			if (chk[n].checked == true) { //체크가 되어있는 값 구분
				checkRow = chk[n].value;

				if (checkCnt == 1) { //체크된 체크박스의 개수가 한 개 일때,
					rowid += checkRow;
				} else { //체크된 체크박스의 개수가 여러 개 일때,
					if (n == checkLast) { //체크된 체크박스 중 마지막 체크박스일 때,
						rowid += checkRow;
					} else {
						rowid += checkRow + ",";
					}

				}
				cnt++;
				checkRow = ''; //checkRow초기화.
			}

		}

	/* 	alert('rowid : ' + rowid); */

		if ((Number(f.adultCount.value) + Number(f.childCount.value)) > 6) {
			alert('한번에 7표 이상 예매하실 수 없습니다')
			return;
		}
		if ((Number(f.adultCount.value) + Number(f.childCount.value)) == 0) {
			alert('최소 1명 이상 예매해야 합니다')
			return;
		}
		if (chkCnt != a + c) {
			alert('좌석 수를 확인해 주세요 ')
			return;
		}
	      var msg = '${msg}';
	      if(msg){
	         alert(msg);
	         location.href="index.do";
	         return;
	      }

		f.sit.value = rowid;

		document.f.action = "client_cashReserve.do";
		document.f.method = "post";
		document.f.submit();

	}

	function imgCbox(N, tabstop) {
		var objs, cboxes, Img, Span, A;

		objs = document.getElementsByTagName("INPUT");
		if (N == undefined)
			return false;
		if (tabstop == undefined)
			tabstop = true;

		for (var i = 0; i < objs.length; i++) {
			if (objs[i].type != "checkbox" || objs[i].name != N)
				continue;

			if (imgCbox.Objs[N] == undefined) {
				imgCbox.Objs[N] = [];
				imgCbox.Imgs[N] = [];
				imgCbox.ImgObjs[N] = [];
			}

			var len = imgCbox.Objs[N].length;
			imgCbox.Objs[N][len] = objs[i];
			imgCbox.Imgs[N][len] = {};

			// for image cache
			(Img = new Image()).src = objs[i].getAttribute("onsrc");
			imgCbox.Imgs[N][len]["on"] = Img;

			(Img = new Image()).src = objs[i].getAttribute("offsrc");
			imgCbox.Imgs[N][len]["off"] = Img;

			// image element
			Img = document.createElement("IMG");
			Img.src = objs[i].checked ? objs[i].getAttribute("onsrc") : objs[i]
					.getAttribute("offsrc");
			Img.style.borderWidth = "0px";
			Img.onclick = new Function("imgCbox.onclick('" + N + "','" + len
					+ "')");
			imgCbox.ImgObjs[N][len] = Img;

			// anchor element for tab stop
			A = document.createElement("A");
			if (tabstop) {
				A.href = "javascript:;";
				A.onkeypress = new Function("evt",
						"if(evt==undefined)evt=event;if(evt.keyCode==13){ imgCbox.onclick('"
								+ N + "','" + len + "'); }");
			}
			A.style.borderWidth = "0px";
			A.appendChild(Img);

			// insert object
			Span = objs[i].parentNode;
			Span.style.display = "none";
			Span.parentNode.insertBefore(A, Span);
		}
	}
	imgCbox.onclick = function(N, idx) {
		var C = imgCbox.Objs[N][idx];
		var I = imgCbox.ImgObjs[N][idx];

		C.checked = !C.checked;
		I.src = imgCbox.Imgs[N][idx][C.checked ? "on" : "off"].src;

		// fire event
		if (C.onclick != undefined || C.onclick != null)
			C.onclick();
	}
	imgCbox.Objs = {};
	imgCbox.Imgs = {};
	imgCbox.ImgObjs = {};
</script>



<section class="content">
	<nav>
		<ul>
			<li>html</li>
			<li>css</li>
			<li>javascript</li>
		</ul>
	</nav>

	<main> <!-- 표수에 맞춰서 좌석 선택 가능하게   / 클릭하면 색 변화로 처리  -->

	<div style="padding: 30px;">
		<br>
		<br>
		<font
			style="font-family: 'Times New Roman'; font-size: 30px; font-weight: bold;">Select
			- Seat</font><br>
		<br>
	</div>
	<p style="line-height: 220px">
	<form name="f">
		<div style="padding-left: 120px">

			어른 : <select name="adultCount" style="width: 50px; height: 20px;">
				<c:forEach var="i" begin="0" end="6" step="1">
					<option value="${i }">${i }</option>
				</c:forEach>
			</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<c:choose>
		<c:when  test="${empty adult }">
			청소년 : <select name="childCount" style="width: 50px; height: 20px;">
				<c:forEach var="j" begin="0" end="6" step="1">
					<option value="${j }">${j }</option>
				</c:forEach>
			</select> 
			</c:when>
			<c:otherwise>
				<input type="hidden" name="childCount" value="0">
			</c:otherwise>
		</c:choose>
			<input type="hidden" name="num" value="${num }"> 
			<input type="hidden" name="theater" value="${theater }"> 
			<input type="hidden" name="time" value="${time }"> 
			<input type="hidden" name="day" value="${day }"> 
			<input type="hidden" name="theaternum" value="${theaternum }">
			<input type="hidden" name="sit">

		</div>
		<hr>
		<div align="right" style="padding-right: 40px">
			<img src="${pageContext.request.contextPath}/img/sitImg/out.png" width="20px"> 예약불가 
			<img src="${pageContext.request.contextPath}/img/sitImg/off.png" width="20px"> 선택가능 
			<img src="${pageContext.request.contextPath}/img/sitImg/on.png" width="20px"> 선택상태
		</div>
		<div
			style="padding-left: 40px; padding-right: 40px; padding-top: 30px">
			<table width="90%" align="center">
				<!-- 전체 리스트 / 예약완료 리스트 / 예약가능 리스트  -->
				<tr>
					<td colspan="2" align="center"
						style="background-color: gray; height: 50px">스크린</td>
				</tr>
				<tr>
					<td colspan="2"><br></td>
				</tr>
				<tr>
					<td align="center">
					<c:set var="count" value="0" /> 
					<c:set 	var="tdCount" value="0" /> 
					<c:forEach var="entry" items="${sit}">
						<%-- <c:out value="${pageContext.request.contextPath}/img/sitImg/${entry.key }_on.png"/> --%>
							<c:choose>
								<c:when test="${entry.value==1 }">
									<img src="${pageContext.request.contextPath}/img/sitImg/${entry.key }.png">
								</c:when>
								<c:otherwise>
									<span>
									<input type="checkbox" name="sitChoice" value="${entry.key}"
										offsrc="${pageContext.request.contextPath}/img/sitImg/${entry.key }_off.png"
										onsrc="${pageContext.request.contextPath}/img/sitImg/${entry.key }_on.png" /> ${entry.key }
									</span>
								</c:otherwise>
							</c:choose>

							<c:set var="count" value="${count+1}" />
							<c:set var="tdCount" value="${tdCount+1}" />
							<c:choose>
								<c:when test="${count %8 ==0.0 }">
										</td>
									</tr>
									<tr>
										<td align="center">
								</c:when> 
								<c:otherwise>
									<c:if test="${tdCount %4 ==0.0 }">
										</td>
										<td align="center">
									</c:if> 
								</c:otherwise> 
							</c:choose> 
							</c:forEach> 
					<script>
						imgCbox("sitChoice");
					</script>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<div
		style="padding-right: 90px; padding-top: 70px; padding-bottom: 70px"
		align="right">
		<a href="javascript:sitCheck()"> 선택완료 </a>
	</div>
	</main>
	<aside>aside</aside>
</section>
<%@ include file="../../bottom.jsp"%>