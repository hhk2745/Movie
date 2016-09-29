<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>free login form -bootstrap</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- font awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<!-- Custom Style -->
<link href="css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></scri.row>.containerpt>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="row" style="margin-left: 350px;">
			<div class="page-header">
				<h2>회원가입</h2>
			</div>
			<div class="col-md-3">
				<div class="login-box well" style="width:200%; align:center;">
					<form name="member_form" method="POST" action="member_Insert.do" onsubmit="return checkValidate()">
						<div class="form-group">
							<label for="username-email">아이디</label> <input
								name="id" value='' id="username-email"
								placeholder="아이디(영문 소문자, 숫자 4~20자)" type="text"
								class="form-control" />
								<input type="button" value="중복확인" 
								onclick="memberIdCheck.do">
						</div>
						<div class="form-group">
							<label for="password">비밀번호</label> 
							<input type="password" name="pw" id="name" value="" 
							maxlength="20" placeholder="(영문 소 대문자, 숫자 6~20자)" 
							id="password"  class="form-control"/>
						</div>
						<div class="form-group">
							<label for="password">비밀번호 확인</label> 
							<input type="password" name="pwr" id="name" value="" 
							maxlength="20"  
							id="password"  class="form-control"/>
						</div>
						<div class="form-group">
							<label for="user-email">이메일</label> 
							<input type="text" name="email" id="email" value="" 
							maxlength="25"  
							id="password"  class="form-control"/>
							<select name="email2">
								<option value="@naver.com">naver.com</option>
								<option value="@gmail.com">gmail.com</option>
								<option value="@daum.net">daum.net</option>
						</select>
						</div>
						<hr />
						<div class="form-group">
							<input type="submit" value="회원가입">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>