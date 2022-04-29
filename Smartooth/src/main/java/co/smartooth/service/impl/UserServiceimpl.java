package co.smartooth.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.smartooth.mapper.UserMapper;
import co.smartooth.service.UserService;
import co.smartooth.vo.MailAuthVO;
import co.smartooth.vo.UserVO;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired(required = false)
	UserMapper userMapper;

	@Override
	public List<UserVO> selectUserList() throws Exception {
			return userMapper.selectUserList();
	}

	
	
}
