<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="㈜스마트코리아" />
<meta name="description" content="Smartooth" />
<title>Smartooth 관리자 페이지</title>
<!-- 						 '/Smartooth/src/main/webapp/WEB-INF/views/st/main.jsp' -->
<%-- <jsp:include page="/Smartooth/src/main/webapp/WEB-INF/views/st/layout/leftMenu.jsp"/> --%>
<%@include file = "/WEB-INF/views/st/layout/menu/left.jsp"%>
<%@include file = "/WEB-INF/views/st/layout/menu/top.jsp"%>
<%-- <jsp:include page="/WEB-INF/views/st/layout/menu/left.jsp"/> --%>
<%-- <jsp:include page="/WEB-INF/views/st/layout/menu/top.jsp"/> --%>

<link href="/css/common/sub.css" rel="stylesheet" type="text/css" />
<link href="/css/common/main.css" rel="stylesheet" type="text/css" />
</head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

// 	$(document).ready(function() {
// 		var smartoothId = GetCookie("smartoothId");
// 		alert("smartoothId >>> "+ smartoothId);
// 		if (smartoothId != "" && smartoothId != "undefined"
// 				&& smartoothId != null) {
// 			$("#login_chk").prop("checked", true);
// 			$("#userId").val(smartoothId);
// 		} else {
// 			$("#login_chk").prop("checked", false);
// 		}
// 		;
// 		$("#userId").focus();
// 	});

// 	function opSubmit() { // 해당 암호화를 사용해야할지 여부 확인
// 		if ($("#userId").val() == "") {
// 			alert("아이디를 입력해주세요.");
// 			$("#userId").focus();
// 			return false;
// 		}
// 		if ($("#userPwd").val() == "") {
// 			alert("비밀번호를 입력해주세요");
// 			$("#userPwd").focus();
// 			return false;
// 		}

// 		if ($("#userId").val() != "") {
// 			var encId = opEncrypt($("#userId").val());
// 			$("#encUserId").val(encId);
// 		}
// 		if ($("#userPwd").val() != "") {
// 			var encPwd = opEncrypt($("#userPwd").val());
// 			$("#encUserPwd").val(encPwd);
// 		}

// 		$("#userId").prop("disabled", true);
// 		$("#userPwd").prop("disabled", true);
// 		$("#frm").submit();
// 	}

// 	function handleCookie() {
// 		alert("쿠키?");
// 		if ($("#login_chk").is(":checked")) {
			
// 			var userId = $("#userId").val();
// 			SetCookie("smartoothId", userId, 365);
// 		} else {
// 			SetCookie("smartoothId", "", -1);
// 		}
// 	}

// 	function getCookieVal(offset) {
// 		var endstr = document.cookie.indexOf(";", offset);
// 		if (endstr == -1)
// 			endstr = document.cookie.length;
// 		return unescape(document.cookie.substring(offset, endstr));
// 	};

// 	function GetCookie(name) {
// 		var arg = name + "=";
// 		var alen = arg.length;
// 		var clen = document.cookie.length;
// 		alert("clen >>> "+ clen);
// 		var i = 0;
// 		while (i < clen) {
// 			var j = i + alen;
// 			if (document.cookie.substring(i, j) == arg)
// 				return getCookieVal(j);
// 			i = document.cookie.indexOf(" ", i) + 1;
// 			if (i == 0)
// 				break;
// 		}
// 		return null;
// 	};

// 	function SetCookie(name, value, expires) {
// 		var argv = SetCookie.arguments;
// 		var argc = SetCookie.arguments.length;
// 		var expires = new Date(Date.now() + (expires * 24 * 60 * 60 * 1000));
// 		var path = "/";
// 		var domain = $(location).attr("host");
// 		alert("domain >>> "+ domain);
// 		document.cookie = name
// 				+ "="
// 				+ escape(value)
// 				+ ((expires == null) ? "" : ("; expires=" + expires
// 						.toGMTString()))
// 				+ ((path == null) ? "" : ("; path=" + path))
// 				+ ((domain == null) ? "" : ("; domain=" + domain));
// 		alert("쿠키생성완료 >>> "+ document.cookie);
// 	};

// 	$(".loginInput").keydown(function(key) {
// 		if (key.keyCode == 13) {
// 			opSubmit();
// 		}
// 	});
</script>
<body class="body">
	<form id="frm" name="frm" method="post" action="/login.do">
		<div class="commonHeight120"></div>
		123123123123123123
		</div>
	</form>
</body>


</html>


