package co.smartooth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.smartooth.mapper.AuthMapper;
import co.smartooth.service.AuthService;
import co.smartooth.vo.AuthVO;


@Service
public class AuthServiceImpl implements AuthService{

	
	@Autowired(required = false)
	AuthMapper authMapper;
	
	
	// 회원 아이디와 비밀번호로 존재 여부 확인 :: true = 1, false = 0
	@Override
	public int loginChkByIdPwd(AuthVO authVO) throws Exception {
		return authMapper.loginChkByIdPwd(authVO);
	}

	// 회원 아이디가 존재하는지 여부 확인 :: true = 1, false = 0
	@Override
	public int isIdExist(String userId) throws Exception {
		return authMapper.isIdExist(userId);
	}
	
}
