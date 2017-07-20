package com.mivim.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mivim.dto.RegisterUserDto;
import com.mivim.dto.UserDto;
import com.mivim.service.UserService;

@Controller
public class UserController {

	@Autowired(required = true)
	@Qualifier("userServiceImpl")
	UserService userService;

	/*
	 * @author SReddy 
	 * 
	 * This method is for userAuthentication
	 * 
	 * @return Map
	 * 
	 * @param UserDto object
	 */
	
	
	@RequestMapping(value = "/authentication", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Map<String, Object> getAuthentication(UserDto dto) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag=userService.authentication(dto);
		if (flag) {
			map.put("status", "200");
			map.put("message", "Your login is Successful");
		} else {
			map.put("status", "400");
			map.put("message", "Your login failed");
		}

		return map;

	}

	/*
	 * This method for Register user
	 * 
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public @ResponseBody Map<String, Object> getRegisterUser(RegisterUserDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userService.register(dto)) {
			map.put("status", "200");
			map.put("message", "Your login is Successful");
		} else {
			map.put("status", "400");
			map.put("message", "Your login failed");
		}

		return map;

	}

}