package co.smartooth.vo;

import java.util.Date;

public class DeviceVO {
	
	private String userNo;
	private String userId;
	private String deviceNm;
	private String deviceCode;
	private String serialNo;
	private String macAddress;
	private Date rgstDt;
	
	
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
	public String getDeviceNm() {
		return deviceNm;
	}
	public void setDeviceNm(String deviceNm) {
		this.deviceNm = deviceNm;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public Date getRgstDt() {
		return rgstDt;
	}
	public void setRgstDt(Date rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	
	
	
}
