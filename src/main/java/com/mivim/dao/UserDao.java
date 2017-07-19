package com.mivim.dao;

import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;

public interface UserDao {
	
	public int authentication(UserDto dto);

	public int register(RegisterUserDto dto);

}
