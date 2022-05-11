package co.smartooth.mapper;

import org.apache.ibatis.annotations.Mapper;
import co.smartooth.vo.MailAuthVO;


@Mapper
public interface MailAuthMapper {

	// 회원 가입을 요청한 유저 DB row에 인증키(AuthKey) 업데이트
	public void updateAuthKeyByUserId(MailAuthVO mailAuthVO) throws Exception;
	
	// UserId로 메일 인증키 발행 후 Database에 입력
	public void insertAuthKeyByUserId(MailAuthVO mailAuthVO) throws Exception;
	
	// 회원가입 시 입력된 아이디(이메일)을 통해 DB에 있는지 조회
	public int selectIdWhetherOrNot(String userId) throws Exception;
	
	// 인증 메일 클릭 시 AuthStatus 'Y'로 변경
	public void updateAuthStatus(String userId) throws Exception;
}
