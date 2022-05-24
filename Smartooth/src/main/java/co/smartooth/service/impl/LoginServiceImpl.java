package co.smartooth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.smartooth.mapper.LoginMapper;
import co.smartooth.service.LoginService;
import co.smartooth.vo.LoginVO;


@Service
public class LoginServiceImpl implements LoginService{

	
	@Autowired(required = false)
	LoginMapper loginMapper;
	
	
	// 회원 아이디와 비밀번호로 존재 여부 확인 :: true = 1, false = 0
	@Override
	public int loginChkByIdPwd(LoginVO loginVO) throws Exception {
		return loginMapper.loginChkByIdPwd(loginVO);
	}

	// 회원 아이디가 존재하는지 여부 확인 :: true = 1, false = 0
	@Override
	public int isIdExist(String userId) throws Exception {
		return loginMapper.isIdExist(userId);
	}
	
	//회원 로그인 처리가 정상적으로 완료될 경우, USER_AUTH_KEY를 UPDATE
	@Override
	public void updateUserAuthToken(LoginVO loginVO) throws Exception {
		loginMapper.updateUserAuthToken(loginVO);
	}

	@Override
	public void insertUserLoginHistory(LoginVO loginVO) throws Exception {
		loginMapper.insertUserLoginHistory(loginVO);
	}

	@Override
	public void updateLoginDt(LoginVO loginVO) throws Exception {
		loginMapper.updateLoginDt(loginVO);
		
	}
	
}
