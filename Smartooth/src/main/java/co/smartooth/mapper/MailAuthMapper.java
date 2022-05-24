package co.smartooth.mapper;

import org.apache.ibatis.annotations.Mapper;
import co.smartooth.vo.MailAuthVO;


@Mapper
public interface MailAuthMapper {

	// UserId로 메일 인증키 발행 후 Database에 입력
	public void insertAuthKeyById(MailAuthVO mailAuthVO) throws Exception;

	// 메일 인증을 요청한 사용자 DB row에 인증키(AuthKey) 업데이트
	public void updateAuthKeyById(MailAuthVO mailAuthVO) throws Exception;

	// 메일 인증 테이블에 USER_ID가 있는지 조회
	public int selectMailAuthInfo(MailAuthVO mailAuthVO) throws Exception;

	
	// 회원가입 시 입력된 아이디(이메일)을 통해 DB에 있는지 조회
	public int selectIdWhetherOrNot(String userId) throws Exception;
	
	// 인증 메일 클릭 시 AuthStatus 'Y'로 변경
	public void updateAuthStatusY(String userId) throws Exception;

	// 인증 메일 재 요청 시 AuthStatus 'N'로 변경
	public void updateAuthStatusN(String userId) throws Exception;
	
	// 사용자 메일 인증 여부
	public String isEmailAuthEnabled(String userId) throws Exception;
}
