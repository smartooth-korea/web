package co.smartooth.utils;

public class TokenUtil {

	// 로그인 시 비밀번호 대신 사용되어질 TOKEN 생성 메소드
	public String createToken(String userId) {
		String tokenKey = null;
		AES256Util aes256Util = new AES256Util();
		tokenKey = aes256Util.aesEncode(userId);
		tokenKey.substring(3,19);
		return tokenKey;
	}
}
