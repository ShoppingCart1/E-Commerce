package com.mivim.service;

import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;

public interface UserService {
	
	public UserDto authentication(UserDto dto);
	public boolean register(RegisterUserDto dto);

}
