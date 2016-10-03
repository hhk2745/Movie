<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
		
		
		
<div class="eventContainer">
	<ul style="margin-top: 50px; margin-bottom: 50px;">
		<li><img src="img\main\main_event.png" alt="eventAlt" style="width:1068px;"></li>
	</ul>
	
	<!-- start -->
	<div class="eventInfoItemContainer">
		<div class="eventImageItem"><img src="img\main\event0.jpg"  height="200px;" width="240px;"></div><!-- image -->
		
		<div class="eventInfoItem">
			<ul>
				<li><strong>이벤트 하나!</strong></li>
			</ul>
			<ul>
				<li>OGV에서 영화를 예매한 뒤 해당 상영관에서 인증샷을 찍어 올려주세요.<br>
					   추첨을 통해 다양한 상품을 드립니다!
				</li>
			</ul>
		</div>
		<div class="eventButtonItem">
			<button onclick="location.href='event1.do'">
				참여하기<br><br>
				GO!
			</button>
		</div>
	</div>
	
	<div class="eventInfoItemContainer">
		<div class="eventImageItem"><img src="img\main\event2.jpg"></div><!-- image -->
		<div class="eventInfoItem">
			<ul>
				<li><strong>마감된 이벤트 입니다.</strong></li>
			</ul>
			<ul>
				<li></li>
			</ul>
		</div>
		<div class="eventButtonItem">
		
		</div>
	</div>
	
	<div class="eventInfoItemContainer">
		<div class="eventImageItem"><img src="img\main\event3.jpg"></div><!-- image -->
		<div class="eventInfoItem">
			<ul>
				<li><strong>마감된 이벤트 입니다.</strong></li>
			</ul>
			<ul>
				<li></li>
			</ul>
		</div>
		<div class="eventButtonItem">
		
		</div>
	</div>
	
	<!-- last -->
	<div class="eventInfoItemContainer">
		<div class="eventImageItem"><img src="img\main\event4.png"></div><!-- image -->
		<div class="eventInfoItem">
			<ul>
				<li><strong>마감된 이벤트 입니다.</strong></li>
			</ul>
			<ul>
				<li></li>
			</ul>
		</div>
		<div class="eventButtonItem">
		
		</div>
	</div>
</div>
<%@ include file="../bottom.jsp"%>
