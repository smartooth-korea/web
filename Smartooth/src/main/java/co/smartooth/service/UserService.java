package co.smartooth.service;

import java.util.List;
import co.smartooth.vo.UserVO;

public interface UserService {

	// 유저 목록 조회
	public List<UserVO> selectUserList() throws Exception;
	
}
