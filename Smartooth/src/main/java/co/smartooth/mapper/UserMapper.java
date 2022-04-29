package co.smartooth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import co.smartooth.vo.UserVO;


@Mapper
public interface UserMapper {

	// 유저 목록 조회
	public List<UserVO> selectUserList() throws Exception;
	
}
