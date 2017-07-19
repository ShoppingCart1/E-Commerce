package com.mivim.daoImpl;

import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mivim.dao.UserDao;
import com.mivim.data.dao.UserMapper;
import com.mivim.data.model.User;
import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;

@Repository
@Resource(name="userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired(required=true)
	@Qualifier("sqlSession")
	SqlSessionTemplate sessionTemplate;
	
	
	@Autowired
	private UserMapper userMapper;
	
	
	
	/*
	 * @see com.mivim.dao.UserDao#authentication(com.mivim.dto.UserDto)
	 * Here we wrote persistence logic
	 * @return Integer
	 * @param UserDto object
	 */
	@Override
	public int authentication(UserDto dto) {
		
		UserDto userDto=sessionTemplate.selectOne("com.mivim.data.dao.UserMapper.selectByExample",dto);
		
		int status;
		if(userDto!=null)
			status=1;
		else
			status=0;
		return status;
	}
	
	public int register(RegisterUserDto dto)
	{
		/*
		dto.setStatus(getStatusCode());
		dto.setId(getUserId());
		dto.setUpdated_date(getDate());
		int status=sessionTemplate.insert("com.mivim.data.dao.UserMapper.insert", dto);
		
		return status;*/
		User user=new User();
		user.setId(getUserId());
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setMobileNumber(dto.getMobileNumber());
		user.setStatus(getStatusCode());
		user.setUpdated_date(getDate());
		int status=userMapper.insert(user);
		return status;
		
		
	}
	
	public static String getUserId()
	{
		return UUID.randomUUID().toString();
	}
	public static int getStatusCode()
	{
		return 1;
	}
	public static Date getDate()
	{
		return new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		
	}

}
