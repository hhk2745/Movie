<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 슬라이드 배너의 핵심은 주황, 노랑, 초록색 영역 -->
<div id="banner_container" style="width:102px;height:58px;overflow:hidden;position:relative;">
    <div id="banner_wrapper" style="width:612px;position:absolute;">
        <img src="<%=request.getContextPath()%>/img/Curr.jpg" style="width:100px;border:solid 1px;float:left;"/>
        <img src="<%=request.getContextPath()%>/img/BEN.PNG" class="page" style="width:100px;border:solid 1px;float:left;"/>
        <img src="<%=request.getContextPath()%>/img/ben.jpg" class="page" style="width:100px;border:solid 1px;float:left;"/>
        <img src="<%=request.getContextPath()%>/img/main.PNG" class="page" style="width:100px;border:solid 1px;float:left;"/>
        <img src="<%=request.getContextPath()%>/img/Curr.jpg" class="page" style="width:100px;border:solid 1px;float:left;"/>
        <img src="<%=request.getContextPath()%>/img/BEN.PNG" style="width:100px;border:solid 1px;float:left;"/>
    </div>
</div>


<!-- 좌우버튼을 생성하여 배너 이동시키기 -->
<div id="banner_navi" align="right">
    <img id="btn_left" src="<%=request.getContextPath()%>/img/btnOK.gif" style="width:50px;" /><!-- 좌 -->
    <img id="btn_right" src="<%=request.getContextPath()%>/img/btnOK.gif" style="width:50px;" /><!-- 우 -->
</div>
    
<!-- 좌우버튼에 대한 이벤트를 생성 -->
<!-- <script type="text/javascript">
	
	var BANNER_INDEX = 1;	//배너의 위치를 저장하는 변수
	var BANNER_LEN = 0;		// 배너의 개수를 정의하는 변수
	var BANNER_WIDTH = 102;	//배너의 넓이를 정의하는 변수
    $(document).ready(function(){
        $("#btn_left").unbind();
        $("#btn_left").bind("click", function(){            
            $("#banner_wrapper").stop();
            $("#banner_wrapper").animate({left:-103}, 1000);
        });
        $("#btn_right").unbind();
        $("#btn_right").bind("click", function(){
            $("#banner_wrapper").stop();
            $("#banner_wrapper").animate({left:103}, 1000);
        });
    });
    function showBannerAt(nIndex){
        if (nIndex != BANNER_INDEX) {
            //  n번째 배너 위치 값 구하기.
            var nPosition = -BANNER_WIDTH * nIndex;
             
            // 슬라이드 시작.
            $("#banner_wrapper").stop();
            $("#banner_wrapper").animate({
                left: nPosition
            }, 200);
            //현재 배너 인덱스 업데이트 시키기.
            BANNENR_INDEX = nIndex;
        }
    }
    
</script>
 -->
<!-- 무한 롤링 -->


<script type="text/javascript">
    var BANNER_INDEX = 1;
    var BANNER_LEN = 0;
    var BANNER_WIDTH = 102;
    var SHOW_DURATION = 200;
    $(document).ready(function(){
         
        bannerInit();
         
        $("#btn_left").unbind();
        $("#btn_left").bind("click", function(){            
            var nIndex = BANNER_INDEX-1;
            // n번째 배너 보이기.  
            showBannerAt(nIndex);
        });
        $("#btn_right").unbind();
        $("#btn_right").bind("click", function(){
            // 이동할 이전 배너 인덱스 값 구하기.
            var nIndex = BANNER_INDEX+1;
             
            // n번째 배너 보이기.
            showBannerAt(nIndex);   
        });
    });
    // nIndex에 해당하는 배너 보이기.
    function showBannerAt(nIndex){
        if (nIndex != BANNER_INDEX) {
                                 
            //  n번째 배너 위치 값 구하기.
            var nPosition = -BANNER_WIDTH * nIndex;
             
            // 배너 메뉴의 위치 값을 업데이트 시킴.
            //showBannerDotAt(nIndex);
             
            // 슬라이드 시작.
            $("#banner_wrapper").stop();
            $("#banner_wrapper").animate({
                left: nPosition
            }, SHOW_DURATION, function(){
                // 이전 내용이 없는 경우 마지막 배너 인덱스 값으로 설정하기.
                if(nIndex<1) {
                    nIndex = BANNER_LEN;
                    nPosition = -BANNER_WIDTH * nIndex;
                    $("#banner_wrapper").css({"left": nPosition + "px"});
                }
 
                // 다음 내용이 없는 경우, 첫 번째 배너 인덱스 값으로 설정하기.
                if(nIndex>BANNER_LEN) {
                    nIndex = 1;
                    nPosition = -BANNER_WIDTH * nIndex;
                    $("#banner_wrapper").css({"left": nPosition + "px"});
                }
 
                //현재 배너 인덱스 업데이트 시키기.
                BANNER_INDEX = nIndex;
            });
        }
    }
 
    function bannerInit(){
        BANNER_LEN = $("#banner_wrapper .page").length;
        $("#banner_wrapper").css({"left": -BANNER_WIDTH});
    }
</script>


<div id="bn_container" style="height:200px;">
    <div id="bn_wrapper">
        <div style="background-color:orange; width:300px;height:170px;border:solid 1px;float:left;"></div>
        <div style="background-color:yellow; width:300px;height:170px;border:solid 1px;float:left;"></div>
        <div style="background-color:green; width:300px;height:170px;border:solid 1px;float:left;"></div>
        <div style="background-color:blue; width:300px;height:170px;border:solid 1px;float:left;"></div>
    </div>
</div>
 
<div id="banner_navi">
    <img id="btn_l" src="/images/left.png" style="width:50px;" />
    <img id="btn_r" src="/images/right.png" style="width:50px;" />
</div>
 
<ul id="nv_container">
    <li class="nv_btn" style="width:50px;display:inline-block">1</li>
    <li class="nv_btn" style="width:50px;display:inline-block">2</li>
    <li class="nv_btn" style="width:50px;display:inline-block">3</li>
    <li class="nv_btn" style="width:50px;display:inline-block">4</li>
</ul>

<script type="text/javascript">
    $(document).ready(function(){
        $("#bn_container").touchSwipe({
            banner_wrp : $("#bn_wrapper"),
            banner_lbt : $("#btn_l"),
            banner_rbt : $("#btn_r"),
            nv_btn : $(".nv_btn")
        });
    });
</script>


    
   