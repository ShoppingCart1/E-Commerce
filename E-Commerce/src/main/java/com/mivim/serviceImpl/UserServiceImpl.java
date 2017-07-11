package com.mivim.serviceImpl;

import java.util.ArrayList;
import java.util.List;

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
	
		boolean flag=false;
		List<RegisterUserDto> userData=getUserData();
		for(RegisterUserDto rdto:userData)
		{
			if(rdto.getEmail().equals(dto.getEmail()) && rdto.getPassword().equals(dto.getPassword()))
				flag=true;
		}
		return flag;
	}

	@Override
	public boolean register(RegisterUserDto dto) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static List<RegisterUserDto> getUserData()
	{
		List<RegisterUserDto> userData=new ArrayList<RegisterUserDto>();
		RegisterUserDto userDto1=new RegisterUserDto();
		userDto1.setId("1");
		userDto1.setEmail("srikanth@gmail.com");
		userDto1.setMobileNumber("8985146220");
		userDto1.setPassword("12345678");
		userDto1.setUsername("srikanthReddy");
		RegisterUserDto userDto2=new RegisterUserDto();
		userDto2.setId("2");
		userDto2.setEmail("umesh@gmail.com");
		userDto2.setMobileNumber("8985146220");
		userDto2.setPassword("12345678");
		userDto2.setUsername("umeshkumar");
		RegisterUserDto userDto3=new RegisterUserDto();
		userDto3.setId("3");
		userDto3.setEmail("suhail@gmail.com");
		userDto3.setMobileNumber("8985146220");
		userDto3.setPassword("12345678");
		userDto3.setUsername("suhail R");
		RegisterUserDto userDto4=new RegisterUserDto();
		userDto4.setId("4");
		userDto4.setEmail("sruti@gmail.com");
		userDto4.setMobileNumber("8985146220");
		userDto4.setPassword("12345678");
		userDto4.setUsername("sruti shingh");
		userData.add(userDto1);
		userData.add(userDto2);
		userData.add(userDto3);
		userData.add(userDto4);
		return userData;
		
	}

}
