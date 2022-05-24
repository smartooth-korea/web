package co.smartooth.mapper;
import org.apache.ibatis.annotations.Mapper;

import co.smartooth.vo.LoginVO;


@Mapper
public interface LoginMapper {

	// public LoginAuthInfo loginAuthInfo(LoginVO loginVO) throws Exception;
	
	// 회원 아이디 존재 여부 :: true = 1, false = 0
	public int loginChkByIdPwd(LoginVO loginVO) throws Exception;
	
	// 회원 아이디가 존재하는지 여부 확인 :: true = 1, false = 0
	public int isIdExist(String userId) throws Exception;
	
	// 회원 로그인 처리가 정상적으로 완료될 경우, USER_AUTH_KEY를 UPDATE
	public void updateUserAuthToken(LoginVO loginVO) throws Exception;
	
	// 회원 로그인 기록 INSERT
	public void insertUserLoginHistory(LoginVO loginVO) throws Exception;
	
	// 회원 접속일 UPDATE
	public void updateLoginDt(LoginVO loginVO) throws Exception;
	
}
