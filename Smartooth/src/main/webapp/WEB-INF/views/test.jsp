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



	//[��û json ������ ����] ::: ġ�� ����
// 	var jsonData = { // Body�� ÷���� json ������
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
// 			type:'POST',   //post ������� ����
// 			url:'/app/user/insertMeasureValue.do',   //�����͸� �ְ���� ���� �ּ�
// 			data:jsonData,   //���� ������ ��� �����͸� �������ش�.
// 			dataType:'html',   //html ���� �������� ���� ��ƿ´�.
// 			success : function(data){   //���� �ְ�ޱⰡ �������� ���. data ���� �ȿ� ���� ��ƿ´�.
// 				$('#message').html(data);  //���� ȭ�� �� id="message" ���� �ȿ� data�ȿ� ��� html �ڵ带 �־��ش�. 
// 			}
// 		});
// 	});


	//[��û json ������ ����] ::: ȸ������ ������
// 	var jsonData = { // Body�� ÷���� json ������
// 		"USER_ID" : "jungjuhyun12@gmail.com"
// 		,"USER_PWD" : "1234"
// 		,"USER_TYPE" : "I"
// 		,"USER_NM" : "������"
// 		,"USER_NICKNAME" : "����Ʈ��"
// 		,"USER_BIRTHDAY" : "1988-01-11"
// 		,"USER_COUNTRY" : "KR"
// 		,"USER_STATE" : ""
// 		,"USER_ADDRESS" : "����� ������ 1004-11 102ȣ"
// 		,"USER_TEL_NO" : "010-9937-4921"
// 		,"USER_SEX" : "M"
// 		,"PUSH_TOKEN" : "P.U.S.H.T.O.K.E.N"
// 		,"TEETH_STATUS" : "123|456|789|012"
// 	};
	
// 	$('#submit').click(function(){ 
// 		$.ajax({
// 			type:'POST',   //post ������� ����
// 			url:'/app/user/register.do',   //�����͸� �ְ���� ���� �ּ�
// 			data:jsonData,   //���� ������ ��� �����͸� �������ش�.
// 			dataType:'html',   //html ���� �������� ���� ��ƿ´�.
// 			success : function(data){   //���� �ְ�ޱⰡ �������� ���. data ���� �ȿ� ���� ��ƿ´�.
// 				$('#message').html(data);  //���� ȭ�� �� id="message" ���� �ȿ� data�ȿ� ��� html �ڵ带 �־��ش�. 
// 			}
// 		});
// 	});


// 	var jsonData = { // Body�� ÷���� json ������
// 			"USER_ID" : "jungjuhyun12@gmail.com"
// 			,"USER_PWD" : "1234"
// 			,"USER_AUTH_KEY" : "USER.AUTH.KEY"
// 		};
		
// 		$('#submit').click(function(){ 
// 			$.ajax({
// 				type:'POST',   //post ������� ����
// 				url:'/app/user/login.do',   //�����͸� �ְ���� ���� �ּ�
// 				data:jsonData,   //���� ������ ��� �����͸� �������ش�.
// 				dataType:'html',   //html ���� �������� ���� ��ƿ´�.
// 				success : function(data){   //���� �ְ�ޱⰡ �������� ���. data ���� �ȿ� ���� ��ƿ´�.
// 					$('#message').html(data);  //���� ȭ�� �� id="message" ���� �ȿ� data�ȿ� ��� html �ڵ带 �־��ش�. 
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
		<input type="submit" value="��ư"/>
	</form>
</body>
</html>