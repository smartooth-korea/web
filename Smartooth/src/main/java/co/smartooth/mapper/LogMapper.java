package co.smartooth.mapper;
import org.apache.ibatis.annotations.Mapper;

import co.smartooth.vo.AuthVO;


@Mapper
public interface LogMapper {

	// 회원 로그인 기록 INSERT
	public void insertUserLoginHistory(AuthVO authVO) throws Exception;
	
	// 회원 접속일 UPDATE
	public void updateLoginDt(AuthVO authVO) throws Exception;
	
}
