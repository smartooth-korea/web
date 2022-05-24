<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){



	//[요청 json 데이터 선언] ::: 치아 측정
// 	var jsonData = { // Body에 첨부할 json 데이터
// 		{"USER_ID" : "jungjuhyun12@gmail.com"
// 		,"USER_NO" : "KR-I-0002"
// 		,"T01" : "01"
// 		,"T02" : "02"
// 		,"T03" : "03"
// 		,"T04" : "04"
// 		,"T05" : "05"
// 		,"T06" : "06"
// 		,"T07" : "07"
// 		,"T08" : "08"
// 		,"T09" : "09"
// 		,"T10" : "10"
// 		,"T11" : "11"
// 		,"T12" : "12"
// 		,"T13" : "13"
// 		,"T14" : "14"
// 		,"T15" : "15"
// 		,"T16" : "16"
// 		,"T17" : "17"
// 		,"T18" : "18"
// 		,"T19" : "19"
// 		,"T20" : "20"
// 		,"T21" : "21"
// 		,"T22" : "22"
// 		,"T23" : "23"
// 		,"T24" : "24"
// 		,"T25" : "25"
// 		,"T26" : "26"
// 		,"T27" : "27"
// 		,"T28" : "28"
// 		,"T29" : "29"
// 		,"T30" : "30"
// 		,"T31" : "31"
// 		,"T32" : "32"}
// 	};
	
// 	$('#submit').click(function(){ 
// 		alert("1");
// 		$.ajax({
// 			type:'POST',   //post 방식으로 전송
// 			url:'/app/user/insertMeasureValue.do',   //데이터를 주고받을 파일 주소
// 			data:jsonData,   //위의 변수에 담긴 데이터를 전송해준다.
// 			dataType:'html',   //html 파일 형식으로 값을 담아온다.
// 			success : function(data){   //파일 주고받기가 성공했을 경우. data 변수 안에 값을 담아온다.
// 				$('#message').html(data);  //현재 화면 위 id="message" 영역 안에 data안에 담긴 html 코드를 넣어준다. 
// 			}
// 		});
// 	});


	//[요청 json 데이터 선언] ::: 회원가입 데이터
// 	var jsonData = { // Body에 첨부할 json 데이터
// 		"USER_ID" : "jungjuhyun12@gmail.com"
// 		,"USER_PWD" : "1234"
// 		,"USER_TYPE" : "I"
// 		,"USER_NM" : "관리자"
// 		,"USER_NICKNAME" : "프론트맨"
// 		,"USER_BIRTHDAY" : "1988-01-11"
// 		,"USER_COUNTRY" : "KR"
// 		,"USER_STATE" : ""
// 		,"USER_ADDRESS" : "서울시 신정동 1004-11 102호"
// 		,"USER_TEL_NO" : "010-9937-4921"
// 		,"USER_SEX" : "M"
// 		,"PUSH_TOKEN" : "P.U.S.H.T.O.K.E.N"
// 		,"TEETH_STATUS" : "123|456|789|012"
// 	};
	
// 	$('#submit').click(function(){ 
// 		$.ajax({
// 			type:'POST',   //post 방식으로 전송
// 			url:'/app/user/register.do',   //데이터를 주고받을 파일 주소
// 			data:jsonData,   //위의 변수에 담긴 데이터를 전송해준다.
// 			dataType:'html',   //html 파일 형식으로 값을 담아온다.
// 			success : function(data){   //파일 주고받기가 성공했을 경우. data 변수 안에 값을 담아온다.
// 				$('#message').html(data);  //현재 화면 위 id="message" 영역 안에 data안에 담긴 html 코드를 넣어준다. 
// 			}
// 		});
// 	});


// 	var jsonData = { // Body에 첨부할 json 데이터
// 			"USER_ID" : "jungjuhyun12@gmail.com"
// 			,"USER_PWD" : "1234"
// 			,"USER_AUTH_KEY" : "USER.AUTH.KEY"
// 		};
		
// 		$('#submit').click(function(){ 
// 			$.ajax({
// 				type:'POST',   //post 방식으로 전송
// 				url:'/app/user/login.do',   //데이터를 주고받을 파일 주소
// 				data:jsonData,   //위의 변수에 담긴 데이터를 전송해준다.
// 				dataType:'html',   //html 파일 형식으로 값을 담아온다.
// 				success : function(data){   //파일 주고받기가 성공했을 경우. data 변수 안에 값을 담아온다.
// 					$('#message').html(data);  //현재 화면 위 id="message" 영역 안에 data안에 담긴 html 코드를 넣어준다. 
// 				}
// 			});
// 		});

// });


	
</script>
<body>
	<form id="frm" name="frm" action="/app/user/login.do" method="post">
		<input type="text" id="USER_ID" name="USER_ID" value="jungjuhyun12@gmail.com"/> 
		<input type="text" id="USER_PWD" name="USER_PWD" value="1234"/> 
		<input type="text" id="USER_AUTH_KEY" name="USER_AUTH_KEY" value="USER.AUTH.KEY"/> 
		<input type="submit" value="버튼"/>
	</form>
</body>
</html>