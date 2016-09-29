<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>





	<!-- 상단 네비게이션 바 -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">

				<!--  -->

				<div class="btn-group">
					<!-- 버튼태그 -->
					<button class="btn btn-default dropdown-toggle" type="button"
						data-toggle="dropdown">
						메뉴버튼
						<!-- 버튼태그 우측 메뉴출력을 위한 화살표표시
        (없어도 무관하나 메뉴버튼이라는것을 알려주기 위함) -->
						<span class="caret"></span>
					</button>
					<!--메뉴버튼 클릭시 하단 표출된 리스트 영역  -->
					<ul class="dropdown-menu">
						<!-- 메뉴1 -->
						<li><a href="#">메뉴1</a></li>
						<!-- 메뉴2 -->
						<li><a href="#">메뉴2</a></li>
					</ul>
				</div>


				<!--  -->



			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">홈으로</a></li>
					<li><a href="#about">부트스트랩이란</a></li>
					<li><a href="#contact">문의하기</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div style="margin-top: 100px;">
			<h1>부트스트랩 기본 템플릿입니다</h1>
			<p class="lead">여러분은 부트스트랩을 이용하여 다양한 기능을 구현할수 있습니다.</p>
		</div>
	</div>

	<div class="btn-group">
		<button type="button" class="btn btn-danger">Action</button>
		<button type="button" class="btn btn-danger dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<span class="caret"></span> <span class="sr-only">Toggle
				Dropdown</span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">Action</a></li>
			<li><a href="#">Another action</a></li>
			<li><a href="#">Something else here</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Separated link</a></li>
		</ul>
	</div>

</body>
</html>
