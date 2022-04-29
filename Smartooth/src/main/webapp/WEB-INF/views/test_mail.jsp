<%@page import="co.smartooth.service.MailAuthService"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/ssi.jsp"%>
<%@ include file="/common/resource.jsp"%>
<%@ page import="co.smartooth.*"%>
<%
MailAuthService ms = new MailAuthService();
	ms.sendMail("jungjuhyun12@gmail.com");
	out.println("COMPLETE");
%>
