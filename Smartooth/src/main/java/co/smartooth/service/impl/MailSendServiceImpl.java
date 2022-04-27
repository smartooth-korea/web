package co.smartooth.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import co.smartooth.auth.MailAuthInfo;
import co.smartooth.service.MailSendService;

@PropertySource(value = { "classpath:application.properties" })
@Service
public class MailSendServiceImpl implements MailSendService{
	

	
	int size;

	// 인증번호 생성
	private String getKey(int size) {
		this.size = size;
		return getAuthCode();
	}

	// 인증코드 난수 발생
	private String getAuthCode() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int num = 0;

		while (buffer.length() < size) {
			num = random.nextInt(10);
			buffer.append(num);
		}

		return buffer.toString();
	}


@Override
public void mailSend(String toEmail) {
		
	
		// 6자리 난수 인증번호 생성
		String authKey = getKey(6);
		
		Properties prop = System.getProperties();
		
		// 로그인시 TLS를 사용할 것인지 설정
		prop.put("mail.smtp.starttls.enable", "true");
		// 이메일 발송을 처리해줄 SMTP서버
		prop.put("mail.smtp.host", "smtp.gmail.com");
		// SMTP 서버의 인증을 사용한다는 의미
		prop.put("mail.smtp.auth", "true");
		// TLS의 포트번호는 587이며 SSL의 포트번호는 465이다.
		prop.put("mail.smtp.port", "587");
		// 프로토콜 관련 예외처리를 위한 TLS 버전 지정		 
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Authenticator auth = new MailAuthInfo();
		// 서버 정보를 application.properties에서 호출하여 사용
		MailAuthInfo mailAuthInfo = new MailAuthInfo();
		Session session = Session.getDefaultInstance(prop, auth);
		MimeMessage msg = new MimeMessage(session);
		
		String serverInfo = mailAuthInfo.getServerInfo();
		String senderId = mailAuthInfo.getUsername();
		String sernderName = mailAuthInfo.getSenderName();
		
		
		
		// 이메일 발송 전 authKey를 Database에 UPDATE
		
		
		
		
		
		
		
		

		try {
			// 보내는 날짜 지정
			msg.setSentDate(new Date());
			// 발송자를 지정한다. 발송자의 메일, 발송자명
			msg.setFrom(new InternetAddress(senderId, sernderName));
			// 수신자의 메일을 생성한다.
			InternetAddress to = new InternetAddress(toEmail);
			// Message 클래스의 setRecipient() 메소드를 사용하여 수신자를 설정한다. setRecipient() 메소드로 수신자, 참조,
			// Message.RecipientType.TO : 받는 사람 // Message.RecipientType.CC : 참조 // Message.RecipientType.BCC : 숨은 참조
			msg.setRecipient(Message.RecipientType.TO, to);
			// 메일의 제목 지정
			msg.setSubject("회원가입 이메일 인증", "UTF-8");

			
			StringBuffer sb = new StringBuffer();
			sb.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>")
			.append("<html xmlns='http://www.w3.org/1999/xhtml'>")
			.append("	<head>")
			.append("		<meta http-equiv='Content-Type' content='text/html charset=utf-8' />")
			.append("		<title>회원가입 인증 메일 ::: ㈜주스마투스코리아</title>")
			.append("	</head>")
			.append("	<tbody style='width: 1024px'>")
			.append("		<tr>")
			.append("			<td height='45' colspan='3' bgcolor='#FFFFFF'></td>")
			.append("		</tr>")
			.append("		<tr>")
			.append("			<td width='5' height='25' bgcolor='#FFFFFF'></td>")
			.append("			<td height='25' colspan='2' bgcolor='#FFFFFF'>")
			.append("				<img src='https://www.smartooth.co/img/logo_origin.png' width='120' height='50' alt='smartooth' border='0' style='display: block'>")
			.append("			</td>")
			.append("		</tr>")
			.append("		<tr>")
			.append("			<td colspan='2'>")
			.append("			<br/>")
			.append("				<h2 style='margin-top: 15px; margin-bottom: 15px;'>[ 회원 가입 이메일 인증 ]</h2>")
			.append("				<div style='width: 100% padding 20px 0'>")
			.append("					<div style='width: 700px margin 0 auto'>")
			.append("						<div style='padding: 10px'>")
			.append("							<p style='line-height: 1.6em'>회원 가입을 계속하려면 아래의 링크를 클릭하십시오. </p>")
			.append("								&nbsp;&nbsp;")
			.append("							<a href='http://")
			.append(serverInfo)
			.append("/app/user/signUpConfirm?email=")
			.append(toEmail)
			.append("&authKey=")
			.append(authKey)
			.append(" target='_blenk'>이메일 인증 확인</a>")
			.append("						</div>")
			.append("						<p style='line-height: 1.4em; font-weight:bold'></p>")
			.append("						<p style='font-size: 11px; color:#636363'></p>")
			.append("					</div>")
			.append("				</div>")
			.append("				<div style='font-size: 11px; color:#636363; background-color:#F4F4F4; line-height:1.3em; padding:20px 30px; margin-top:25px'>")
			.append("					본 메일은 발신 전용이므로 메일로 문의 시 확인이 불가능합니다.")
			.append("					<br/>")
			.append("					다른 궁금하신 사항은 웹사이트(<a href='http://smartooth.co/about_us' target='_blank'>www.smartooth.co</a> 또는 이메일 <a href='mailto:﻿smartooth@smartooth.co'>smartooth@smartooth.co</a> 문의해 주세요.")
			.append("					<br/>")
			.append("				</div>")
			.append("			</td>")
			.append("		</tr>")
			.append("	</body>")
			.append("</html>");
			
			// text로만 보내고 싶을 경우 setText를 사용
			// msg.setText(sb.toString());
			// html로 보내고 싶을 경우 setContents 사용
			msg.setContent(sb.toString(), "text/html;charset=euc-kr");
			
			// Transport는 메일을 최종적으로 보내는 클래스로 메일을 전송			
			Transport.send(msg);
			
					


		} catch (AddressException ae) {
			System.out.println("AddressException : " + ae.getMessage());
		} catch (MessagingException me) {
			System.out.println("MessagingException : " + me.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException : " + e.getMessage());
		}
	}
}
