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
	
	// 사용자 등록 (회원가입)
	public void insertUser(UserVO userVo) throws Exception;

	// 사용자 정보 업데이트 (회원가입)
	public void updateUser(UserVO userVo) throws Exception;
	
	// 사용자 번호 (회원 번호 생성 전 SEQ_NO) 조회
	public int selectUserSeqNo() throws Exception;
	
	// 사용자 번호 (회원 번호 생성 후 SEQ_NO) 업데이트 
	public void updateUserSeqNo(int seqNo) throws Exception;

	// 사용자 목록 조회
	public List<UserVO> selectUserList(String userId) throws Exception;


	
}
