package com.mivim.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mivim.dao.UserDao;
import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;
import com.mivim.service.UserService;

@Service
@Resource(name="userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDaoImpl")
	UserDao userDao;
	
	/*
	 * @author SReddy
	 * @see com.mivim.service.UserService#authentication(com.mivim.dto.UserDto)
	 * @return boolean
	 * @param UserDto object
	 */
	public boolean authentication(UserDto dto) {
		boolean flag=false;
		int val= userDao.authentication(dto);
		if(val!=0)
			flag=true;
		else
			flag=false;
		
		return flag;
	}

	@Override
	public boolean register(RegisterUserDto dto) {
		int status=userDao.register(dto);
		return true;
	}
	
	

}
