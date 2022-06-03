package co.smartooth.service;

import org.springframework.stereotype.Service;

import co.smartooth.auth.AuthInfo;
import co.smartooth.vo.AuthVO;


@Service
public interface LogService {
	
	// 회원 로그인 기록 INSERT
	public void insertUserLoginHistory(AuthVO authVO) throws Exception;
	
	// 회원 접속일 UPDATE
	public void updateLoginDt(AuthVO authVO) throws Exception;

}