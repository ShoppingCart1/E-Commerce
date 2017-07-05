package com.mivim.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mivim.dao.UserDao;
import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;
import com.mivim.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	/*
	 * @author SReddy
	 * @see com.mivim.service.UserService#authentication(com.mivim.dto.UserDto)
	 * @return boolean
	 * @param UserDto object
	 */
	public boolean authentication(UserDto dto) {
	
		return false;
	}

	@Override
	public boolean register(RegisterUserDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
