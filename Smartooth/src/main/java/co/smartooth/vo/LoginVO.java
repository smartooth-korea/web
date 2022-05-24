package co.smartooth.vo;

import java.util.Date;

public class LoginVO {
	
	private String userNo;
	private String userId;
	private String userPwd;
	private String userType;
	private Date loginDt;
	private String loginResultCode;
	private String loginIp;
	private String userAuthToken;
	
//	private boolean rememberId;
	
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Date getLoginDt() {
		return loginDt;
	}
	public void setLoginDt(Date loginDt) {
		this.loginDt = loginDt;
	}
	public String getLoginResultCode() {
		return loginResultCode;
	}
	public void setLoginResultCode(String loginResultCode) {
		this.loginResultCode = loginResultCode;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getUserAuthToken() {
		return userAuthToken;
	}
	public void setUserAuthToken(String userAuthToken) {
		this.userAuthToken = userAuthToken;
	}
		
//		public boolean isRememberId() {
//			return rememberId;
//		}
//		public void setRememberId(boolean rememberId) {
//			this.rememberId = rememberId;
//		}
}
