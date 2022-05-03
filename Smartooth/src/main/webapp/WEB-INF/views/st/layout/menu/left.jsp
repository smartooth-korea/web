<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
#left-nav {
	width: 330px;
	height: calc(100% - 40px);
	position: fixed;
	top: 100px;
	left: 0;
	z-index: 100;
	background-color: #4D4D4D;
	overflow-x: hidden;
	overflow-y: hidden;
}

#left-nav ul.left-ul {
	width: 330px;
	margin: 0px;
	padding: 0px;
	list-style: none;
}

.left-li div.left-div {
	width: 330px;
	height: 72px;
	border: 0px solid gray;
}

#left-nav ul.left-ul {
	width: 330px;
	margin: 0px;
	padding: 0px;
	list-style: none;
}

.left-ul li.left-li {
	float: left;
	font-size: 12px;
}

.left-li div.sub-left-div-hr {
	width: 330px;
	height: 25px;
	border: 0px solid gray;
}

.left-li div.sub-left-div {
	width: 330px;
	height: 72px;
	border: 0px solid gray;
}

/**버튼 이미지 **/
#sub-left-div-dashboard {
	background-image: url('/imgs/layout/menu/button/dashboard.png');
}

#sub-left-div-usermanage {
	background-image: url('/imgs/layout/menu/button/usermanage.png');
}

#sub-left-div-statistics {
	background-image: url('/imgs/layout/menu/button/statistics.png');
}

.sub-left-div{
	cursor: pointer;
}

.sub-left-div a.sub-left-a {
	/*font-family:Noto Sans KR; */
	display: block;
	height: 72px;
	color: #FFFFFF;
	position: fixed;
	left: 30px;
	font-size: 20px;
	text-align: left;
	text-decoration: none;
	transition: all 0.3s ease;
}

.sub-left-div a.sub-left-a:hover {
	color: #000000;
}

/**캐릭터 및 나의 정보**/
.sub-left-div-myinfo {
	width: 40%;
	height: 100px;
	border: 0px solid gray;
	float:left;
}

img:hover {
	cursor: pointer;
}
</style>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
// 	마우스 오버 효과
// 	$("#sub-left-div-dashboard")
// 	.mouseenter(function(e){
//         var _this = $(this);
//         _this.addClass('hover');
//     }).mouseleave(function(e){
//         var _this = $(this);
//         _this.removeClass('hover');
//     });
// 	$("#sub-left-div-usermanage")
// 	.mouseenter(function(e){
//         var _this = $(this);
//         _this.addClass('hover');
//     }).mouseleave(function(e){
//         var _this = $(this);
//         _this.removeClass('hover');
//     });
// 	$("#sub-left-div-statistics")
// 	.mouseenter(function(e){
//         var _this = $(this);
//         _this.addClass('hover');
//     }).mouseleave(function(e){
//         var _this = $(this);
//         _this.removeClass('hover');
//     });

	// 로딩 시 대시 보드가 활성화 되도록 설정
	var title = $("#title").val();
	$("#sub-left-div-"+title).css({"background":"url(/imgs/layout/menu/button/"+title+"_hover.png)"});
});
	
function movePage(title){
		if(title == "dashboard"){
			// 대쉬보드 버튼 - 활성화, 사용자관리&통계정보 버튼 - 비활성화
			$("#sub-left-div-"+title).css({"background":"url(/imgs/layout/menu/button/"+title+"_hover.png)"}); 	
			$("#sub-left-div-usermanage").css({"background":"url(/imgs/layout/menu/button/usermanage.png)"}); 	
			$("#sub-left-div-statistics").css({"background":"url(/imgs/layout/menu/button/statistics.png)"});
			
			location.href = "main.do";
			
		}else if(title == "usermanage"){
			// 사용자관리 - 활성화, 대쉬보드 버튼&통계정보 버튼 - 비활성화
			$("#sub-left-div-"+title).css({"background":"url(/imgs/layout/menu/button/"+title+"_hover.png)"}); 	
			$("#sub-left-div-dashboard").css({"background":"url(/imgs/layout/menu/button/dashboard.png)"}); 	
			$("#sub-left-div-statistics").css({"background":"url(/imgs/layout/menu/button/statistics.png)"});

			location.href = "user.do";
			
		}else if(title == "statistics"){
			// 통계정보 버튼 - 활성화, 대쉬보드&사용자관리 버튼 - 비활성화
			$("#sub-left-div-"+title).css({"background":"url(/imgs/layout/menu/button/"+title+"_hover.png)"}); 	
			$("#sub-left-div-dashboard").css({"background":"url(/imgs/layout/menu/button/dashboard.png)"}); 	
			$("#sub-left-div-usermanage").css({"background":"url(/imgs/layout/menu/button/usermanage.png)"});

			location.href = "#";
			
		}
}
	
</script>
<input type="hidden" id="title" value="${title}"/>
	<div id="left-nav" class="jui">
		<div class="left-ul" style="height: 100%;">
			<div class="left-li">
				<div class="sub-left-div-myinfo">
					<!-- mypage로 이동 -->
					<img alt="" src="/imgs/layout/menu/icon/tn.png" onclick="#" style=" display:inline-block; position: fixed; left: 30px; top: 140px">
				</div>
				<div style="color: #FFFFFF; margin-top: 32px; margin-bottom: 35px;">
						<div  style="font-size: 24px;">정주현</div>
						<div style="font-size: 12px;">서버개발자</div>
						<div style="font-size: 12px;">2022/05/02</div>
						<div class="commonHeight5"></div>
						<div style="font-size: 12px;"><input type="button" value="로그아웃" onclick="location.href='/logout'"> </div>
				</div>
			</div>
			<div class="left-li">
				<div class="sub-left-div-hr">
					<hr style="border: solid 1px #3F3F3F; width: 85%">
				</div>
			</div>

			<div class="left-li">
				<div id="sub-left-div-dashboard" class="sub-left-div" onclick="movePage('dashboard');">
				</div>
			</div>
			<div class="left-li">
				<div id="sub-left-div-usermanage" class="sub-left-div" onclick="movePage('usermanage');">
				</div>
			</div>
			<div class="left-li">
				<div id="sub-left-div-statistics" class="sub-left-div" onclick="movePage('statistics');">
				</div>
			</div>
		</div>
	</div>