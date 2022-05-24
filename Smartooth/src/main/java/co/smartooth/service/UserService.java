package co.smartooth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.smartooth.vo.UserVO;

public interface UserService {
	
	/**
	 * params : 
	 * 작성자 : 정주현 
	 * 작성일 : 2022. 4. 28
	 * return : HashMap<String,Object>
	 */
	
	// 회원 아이디 중복 체크
	public int duplicateChkId(String userId) throws Exception;
	
	//	회원 등록 (회원가입)
	public void insertUser(HashMap<String, Object> map) throws Exception;

	// 회원 정보 업데이트 (회원가입)
	//	public void updateUser(UserVO userVo) throws Exception;
	public void updateUser(HashMap<String, Object> map) throws Exception;
	
	// 회원 치아 상태 INSERT
	public void insertUserTeethInfo(HashMap<String, Object> map) throws Exception;
	
	// 회원 번호 (회원 번호 생성 전 SEQ_NO) 조회
	public Integer selectUserSeqNo() throws Exception;
	
	// 회원 번호 (회원 번호 생성 후 SEQ_NO) 업데이트 
	public void updateUserSeqNo(int seqNo) throws Exception;

	// 회원 정보 조회
	public List<UserVO> selectUserInfo(UserVO userVO) throws Exception;

	// 회원 치아 측정 값 입력 INSERT
	public void insertTeethMeasureValue(HashMap<String, Object> map) throws Exception;

	// 회원 치아 측정 값 입력 UPDATE
	public void updateTeethMeasureValue(HashMap<String, Object> map) throws Exception;

	// 회원 아이디 혹은 회원 번호로 조회했을 때 회원이 측정했던 날짜가 오늘인지 아닌지 조회 후 반환
	public Integer selectTeethMeasureValueByDate(HashMap<String, Object> map) throws Exception;
	
	// 회원의 TEETH_STATUS(상태 값) INSERT
	public void insertTeethStatus(HashMap<String, Object> map) throws Exception; 
	
	
	
	
	
	
	
	
	
	// 회원 삭제
	public void deleteUser(String userId) throws Exception;
}
