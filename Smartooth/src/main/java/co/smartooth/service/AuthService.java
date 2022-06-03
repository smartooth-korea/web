package co.smartooth.service;

import org.springframework.stereotype.Service;

import co.smartooth.auth.AuthInfo;
import co.smartooth.vo.AuthVO;


@Service
public interface AuthService {

	// 회원 아이디와 비밀번호로 존재 여부 확인 :: true = 1, false = 0
	public int loginChkByIdPwd(AuthVO authVO) throws Exception;
	
	// 회원 아이디가 존재하는지 여부 확인 :: true = 1, false = 0
	public int isIdExist(String userId) throws Exception;
	

}