package co.smartooth.service;

import co.smartooth.vo.MailAuthVO;

public interface MailAuthService {
	
	/**
	 * params : userId = 이메일
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 28
	 * return : HashMap<String,Object>
	 */
	// 메일 발송
	public void sendMail(String userId) throws Exception;
	
	// UserId로 메일 인증키 발행 후 Database 에 입력
	void insertAuthKeyById(MailAuthVO mailAuthVO) throws Exception;

	// 메일 인증키 업데이트
	public void updateAuthKeyById(MailAuthVO mailAuthVO) throws Exception;
	
	// 사용자 아이디 있는지 여부 확인 :: 있을 경우 1, 없을 경우 0을 반환
	public void updateAuthStatus(String userId);
	
	// 사용자 존재 여부 확인 (유효성 검사)
	public boolean isValidation(MailAuthVO mailAuthVO) throws Exception;




	
}
