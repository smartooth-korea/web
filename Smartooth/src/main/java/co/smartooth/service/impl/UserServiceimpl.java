package co.smartooth.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.smartooth.mapper.UserMapper;
import co.smartooth.service.UserService;
import co.smartooth.vo.UserVO;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired(required = false)
	UserMapper userMapper;

	// 아이디 중복 체크
	@Override
	public int duplicateChkId(String userId) throws Exception {
		return userMapper.duplicateChkId(userId);
	}

	
	//	회원 등록 (회원가입)
	@Override
	public void insertUser(HashMap<String, Object> map) throws Exception {
		userMapper.insertUser(map);
	}
	
	// 회원 정보 업데이트 (회원가입)
	@Override
	//	public void updateUser(UserVO userVo) throws Exception {
	public void updateUser(HashMap<String, Object> map) throws Exception {
		userMapper.updateUser(map);
	}
	
	@Override
	public void insertUserTeethInfo(HashMap<String, Object> map) throws Exception {
		userMapper.insertUserTeethInfo(map);
	}
	
	// 회원 번호 (회원 번호 생성 전 SEQ_NO) 조회
	@Override
	public Integer selectUserSeqNo() throws Exception {
		return userMapper.selectUserSeqNo();
	}
	
	// 회원 번호 (회원 번호 생성 후 SEQ_NO) 업데이트 
	@Override
	public void updateUserSeqNo(int seqNo) throws Exception {
		userMapper.updateUserSeqNo(seqNo);
	}
	
	// 회원 목록 조회
	@Override
	public List<UserVO> selectUserInfo(UserVO userVO) throws Exception {
		return userMapper.selectUserInfo(userVO);
	}

	// 회원 치아 측정 값 입력 INSERT
	@Override
//	public void insertTeethMeasureValue(HashMap<String, Object> map) throws Exception { 
	public void insertTeethMeasureValue(HashMap<String, Object> map) throws Exception {
		userMapper.insertTeethMeasureValue(map);
	}

	// 회원 치아 측정 값 입력 UPDATE
	@Override
	public void updateTeethMeasureValue(HashMap<String, Object> map) throws Exception {
		userMapper.updateTeethMeasureValue(map);
	}
	
	
	// 회원 아이디 혹은 회원 번호로 조회했을 때 회원이 측정했던 날짜가 오늘인지 아닌지 조회 후 반환
	@Override
	public Integer selectTeethMeasureValueByDate(HashMap<String, Object> map) throws Exception {
		return userMapper.selectTeethMeasureValueByDate(map);
	}

	// 회원의 TEETH_STATUS(상태 값) INSERT
	@Override
	public void insertTeethStatus(HashMap<String, Object> map) throws Exception {
		userMapper.insertTeethStatus(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	// 회원의 삭제
	@Override
	public void deleteUser(String userId) throws Exception {
		userMapper.deleteUser(userId);
	}
}