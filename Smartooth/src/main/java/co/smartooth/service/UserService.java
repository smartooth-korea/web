package co.smartooth.service;

import java.util.List;
import co.smartooth.vo.UserVO;

public interface UserService {
	
	/**
	 * params : 
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 28
	 * return : HashMap<String,Object>
	 */
	
	// 유저 목록 조회
	public List<UserVO> selectUserList() throws Exception;
	
}
