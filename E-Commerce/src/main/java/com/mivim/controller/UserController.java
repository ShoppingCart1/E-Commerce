package com.mivim.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;
import com.mivim.service.UserService;

@Controller
public class UserController {
	
	 
	@Autowired
	UserService userService;
	
	/*
	 * @author SReddy
	 * This method is for userAuthentication
	 * @return Map
	 * @param UserDto object
	 */
	@RequestMapping(value="/authentication",method=RequestMethod.POST)
	public Map<String,Object> getAuthentication(UserDto dto)
	{

		Map<String, Object> map=new HashMap<String,Object>();
		
		
		if(userService.authentication(dto)){
			map.put("status","200");
			map.put("message","Your login is Successful");
		}
		else
		{
			map.put("status","400");
			map.put("message","Your login failed");
		}
		return map;
		
	}
	/*
	 * This method for Register user
	 * 
	 */
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public Map<String,Object> getRegisterUser(RegisterUserDto dto)
	{
		Map<String, Object> map=new HashMap<String,Object>();
		if(userService.register(dto)){
			map.put("status","200");
			map.put("message","Your login is Successful");
		}
		else
		{
			map.put("status","400");
			map.put("message","Your login failed");
		}
		return null;
		
	}

}
