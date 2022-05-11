package co.smartooth.service.impl;

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

	// 사용자 등록 (회원가입)
	@Override
	public void insertUser(UserVO userVo) throws Exception {
		userMapper.insertUser(userVo);
	}
	
	// 사용자 정보 업데이트 (회원가입)
	@Override
	public void updateUser(UserVO userVo) throws Exception {
		userMapper.updateUser(userVo);
	}
	
	// 사용자 번호 (회원 번호 생성 전 SEQ_NO) 조회
	@Override
	public int selectUserSeqNo() throws Exception {
		return userMapper.selectUserSeqNo();
	}
	
	// 사용자 번호 (회원 번호 생성 후 SEQ_NO) 업데이트 
	@Override
	public void updateUserSeqNo(int seqNo) throws Exception {
		userMapper.updateUserSeqNo(seqNo);
	}
	
	// 사용자 목록 조회
	@Override
	public List<UserVO> selectUserList(String userId) throws Exception {
		return userMapper.selectUserList();
	}

	
}
