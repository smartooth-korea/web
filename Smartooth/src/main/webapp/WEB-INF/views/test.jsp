<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	alert("테스트다임마");
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