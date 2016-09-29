<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">WebSiteName</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="#">회원관리</a></li>
				<li class="active"><a href="#">영화관리</a></li>
				<li><a href="#">상영관 관리</a></li>
				<li><a href="#">매출관리</a></li>
				<li><a href="#">게시판관리</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> Tutorials <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">HTML</a></li>
						<li><a href="#">CSS</a></li>
						<li><a href="#">JavaScript</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
				<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>
			</ul>
		</div>
	</div>
</nav>
</head>
<body>

	<div class="container">
		<br> <br> <br>
		<h2>Movie List</h2>
		<ul class="nav nav-tabs" role="tablist">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">About1</a></li>
			<li><a href="#">About2</a></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Tutorials <span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">HTML</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul></li>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<form class="form-horizontal">
						<div class="form-group">
							<div class="col-sm-10">
								<input type="password" class="form-control" id="pwd"
									placeholder="Enter password">
							</div>
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-search"></span> Search
								</button>
							</div>
						</div>
					</form>
				</li>
			</ul>

		</ul>
	</div>
	<div class="row" align="center">
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
		<div class="col-sm-4">
			<img src="/img/ben.jpg" class="img-rounded" alt="Cinque Terre"
				width="304" height="236">
		</div>
	</div>

</body>
</html>