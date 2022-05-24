package co.smartooth.service;

import org.springframework.stereotype.Service;

import co.smartooth.auth.LoginAuthInfo;
import co.smartooth.vo.LoginVO;


@Service
public interface LoginService {

//	public LoginAuthInfo loginAuthInfo(LoginVO loginVO) throws Exception;
	
	// 회원 아이디와 비밀번호로 존재 여부 확인 :: true = 1, false = 0
	public int loginChkByIdPwd(LoginVO loginVO) throws Exception;
	
	// 회원 아이디가 존재하는지 여부 확인 :: true = 1, false = 0
	public int isIdExist(String userId) throws Exception;
	
	// 회원 로그인 처리가 정상적으로 완료될 경우, USER_AUTH_TOKEN을 UPDATE
	public void updateUserAuthToken(LoginVO loginVO) throws Exception;
	
	// 회원 로그인 기록 INSERT
	public void insertUserLoginHistory(LoginVO loginVO) throws Exception;
	
	// 회원 접속일 UPDATE
	public void updateLoginDt(LoginVO loginVO) throws Exception;

}