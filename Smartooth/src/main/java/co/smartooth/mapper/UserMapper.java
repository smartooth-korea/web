package co.smartooth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import co.smartooth.vo.UserVO;


@Mapper
public interface UserMapper {

	// 사용자 등록 (회원가입)
	public void insertUser(UserVO userVO) throws Exception;
	
	// 사용자 정보 업데이트 (회원가입)
	public void updateUser(UserVO userVo) throws Exception;
	
	// 사용자 번호 (회원 번호 생성 전 SEQ_NO) 조회
	public int selectUserSeqNo() throws Exception;
	
	// 사용자 번호 (회원 번호 생성 후 SEQ_NO) 업데이트 
	public void updateUserSeqNo(int seqNo) throws Exception;
	
	// 사용자 목록 조회
	public List<UserVO> selectUserList() throws Exception;
	
}