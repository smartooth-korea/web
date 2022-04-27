package co.smartooth.auth;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
@Component
public class MailAuthInfo extends Authenticator{
    
    PasswordAuthentication pa;
    
    private static String username;
    private static String password;
    private static String serverIp;
    private static String serverPort;
    private static String senderName;

    
    // Getter, Setter
    @Value("${spring.mail.username}")
    public void setUsername(String value) {
    	username = value;
    }
    
    @Value("${spring.mail.password}")
    public void setPassword(String value) {
    	password = value;
    }

    @Value("${spring.mail.sendername}")
    public void setSenderName(String value) {
    	senderName = value;
    }
    
	@Value("${spring.server.ip}")
    public void setServerIp(String value) {
		serverIp = value;
    }
    
	@Value("${spring.server.port}")
    public void setServerPort(String value) {
		serverPort = value;
    }
	
	
    
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getServerIp() {
		return serverIp;
	}

	public String getServerPort() {
		return serverPort;
	}
	
	public String getServerInfo() {
		return serverIp + ":" + serverPort;
    }
    
    public String getSenderName() {
    	return senderName;
    }
    
    
    
    
    public MailAuthInfo() {
        pa = new PasswordAuthentication(username, password);
    }
    
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
    
    
   
}
