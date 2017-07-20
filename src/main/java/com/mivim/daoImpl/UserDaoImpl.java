package com.mivim.daoImpl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mivim.dao.UserDao;
import com.mivim.data.dao.UserMapper;
import com.mivim.data.model.User;
import com.mivim.data.model.UserExample;
import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;

@Repository
@Resource(name = "userDaoImpl")
public class UserDaoImpl implements UserDao {

	private static Date date = Utils.getDate();
	private static String userId = Utils.getUUId();
	private static int status = Utils.getStatusCode();

	@Autowired
	private UserMapper userMapper;

	@Autowired(required = true)
	@Qualifier("userExample")
	UserExample userExample;

	@Autowired
	@Qualifier("user")
	User user;

	/*
	 * @see com.mivim.dao.UserDao#authentication(com.mivim.dto.UserDto) Here we
	 * wrote persistence logic
	 * 
	 * @return Integer
	 * 
	 * @param UserDto object
	 */
	@Override
	public UserDto authentication(UserDto dto) {

		userExample.or().andEmailEqualTo(dto.getEmail());
		userExample.or().andPasswordEqualTo(dto.getPassword());

		List<User> userList = userMapper.selectByExample(userExample);
		UserDto userDto = new UserDto();
		for (User user : userList) {
			if (user.getEmail().equals(dto.getEmail()) && user.getPassword().equals(dto.getPassword())) {
				userDto.setId(user.getId());
				userDto.setEmail(user.getEmail());
				userDto.setUsername(user.getUsername());

			}
		}

		return userDto;

	}

	@Override
	public int register(RegisterUserDto dto) {

		user.setId(userId);
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setMobileNumber(dto.getMobileNumber());
		user.setStatus(status);
		user.setUpdated_date(date);
		int status = userMapper.insert(user);
		return status;

	}

}
