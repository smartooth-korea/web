package co.smartooth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.smartooth.mapper.LogMapper;
import co.smartooth.service.LogService;
import co.smartooth.vo.AuthVO;


@Service
public class LogServiceImpl implements LogService{

	
	@Autowired(required = false)
	LogMapper logMapper;
	
	

	// 회원 로그인 기록 INSERT
	@Override
	public void insertUserLoginHistory(AuthVO authVO) throws Exception {
		logMapper.insertUserLoginHistory(authVO);
	}

	
	// 회원 접속일 UPDATE
	@Override
	public void updateLoginDt(AuthVO authVO) throws Exception {
		logMapper.updateLoginDt(authVO);
		
	}
}
