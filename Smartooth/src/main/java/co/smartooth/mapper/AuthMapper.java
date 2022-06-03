package co.smartooth.mapper;
import org.apache.ibatis.annotations.Mapper;

import co.smartooth.vo.AuthVO;


@Mapper
public interface AuthMapper {

	// 회원 아이디 존재 여부 :: true = 1, false = 0
	public int loginChkByIdPwd(AuthVO authVO) throws Exception;
	
	// 회원 아이디가 존재하는지 여부 확인 :: true = 1, false = 0
	public int isIdExist(String userId) throws Exception;

}
