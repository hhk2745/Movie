<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 현재 작성하고 있는 파일은 UTF-8 DOS파일입니다.-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
	<div id="ex_js_syntax">
		<script type="text/javascript" language="javascript">
		<!--
			/* Form Events onfocus onblur onchange onsubmit 
			onsubmit은 생략 form에 이벤트 걸면 됩니다.(티스토리 소스 꼬임)
			ex) form action="sub_form.php" onsubmit="sub_send()*/
			function onfocus_event() {
				/* onfocus 이벤트 */
				alert("onfocus 실행되였어요");
			}
			function onblur_event() {
				/* onblur 이벤트 */
				alert("onblur 실행되였어요");
			}
			function onchange_event() {
				/* onblur 이벤트 */
				alert("onchange 실행되였어요");
			}

			//-->
		</script>
		
		
		<script type="text/javascript">
		function onblur_eventTest() {
			/* onblur 이벤트 */
			input_type.name.value;
			if (Trim(input_type.name.value == "") || input_type.name.value == null) {
				input_type.name.value == "아디를 입력하세여";
				alert('onblur')
			}
			alert('dd')
			
		}
		</script>
	
		
		<form name="input_type" method="post">
			<!-- 예제 박스에선 안됨 => form태그안에 form태그있으면 지워짐~ㅠ.ㅠ -->
			<input type="text" value="포커스 얻을시 실행" onfocus="onfocus_event();">
			<br /> <input type="text" name="test"
				onclick="if(this.value=='아디를 입력하세여'){this.value=''}"
				value="아디를 입력하세여" onblur="onblur_eventTest();"><br /> <select
				name="atte_select_base" onchange="onchange_event();">
				<option value="base">기본</option>
				<option value="apple">사과</option>
				<option value="orange">오렌지</option>
			</select> <br /> 
			<input type="text" name="id" value="아디" onfocus="this.value=''" onblur="if(this.value==''){this.value='아디'}" />
			<input type="text" name="dd" plaseholder="ddddddddd"></input>
		</form>
	</div>
</body>
</html>