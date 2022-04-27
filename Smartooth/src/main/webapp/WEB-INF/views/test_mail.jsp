<%@page import="co.smartooth.service.MailSendService"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/ssi.jsp"%>
<%@ include file="/common/resource.jsp"%>
<%@ page import="co.smartooth.*"%>
<%
MailSendService ms = new MailSendService();
	ms.mailSend("jungjuhyun12@gmail.com");
	out.println("COMPLETE");
%>
