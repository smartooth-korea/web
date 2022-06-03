package co.smartooth.service;

import co.smartooth.vo.MailAuthVO;

public interface MailAuthService {
	
	/**
	 * params : userId = 이메일
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 28
	 * return : HashMap<String,Object>
	 * @return 
	 */
	// 메일 발송
	public void sendMail(String userId) throws Exception;

	public void sendResetPasswordMail(String userId, String emailAuthKey) throws Exception;
	
	// UserId로 메일 인증 번호 발행 후 Database 에 입력
	void insertAuthKeyById(MailAuthVO mailAuthVO) throws Exception;

	// 메일 인증 번호 업데이트
	public void updateAuthKeyById(MailAuthVO mailAuthVO) throws Exception;
	
	// 인증 메일 클릭 시 인증 상태를 'Y' 로 업데이트
	public void updateAuthStatusY(String userId) throws Exception;

	// 인증 메일 요청 시 인증 상태를 'N' 로 업데이트
	public void updateAuthStatusN(String userId) throws Exception;
	
	// 사용자 메일 인증 여부 확인
	public String isEmailAuthEnabled(String userId) throws Exception;

	// 회원 존재 여부 확인 (유효성 검사)
	//	public boolean isValidation(MailAuthVO mailAuthVO) throws Exception;
	

	
}
