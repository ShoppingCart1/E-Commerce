package com.mivim.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;
import com.mivim.service.UserService;

@Service
@Resource(name="userServiceImpl")
public class UserServiceImpl implements UserService {

//	@Autowired
//	UserDao userDao;
	
	/*
	 * @author SReddy
	 * @see com.mivim.service.UserService#authentication(com.mivim.dto.UserDto)
	 * @return boolean
	 * @param UserDto object
	 */
	public boolean authentication(UserDto dto) {
	
		return true;
	}

	@Override
	public boolean register(RegisterUserDto dto) {
		// TODO Auto-generated method stub
		return true;
	}

}
