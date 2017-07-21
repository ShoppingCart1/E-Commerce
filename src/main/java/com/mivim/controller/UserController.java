package com.mivim.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public @ResponseBody Map<String, Object> getAuthentication(HttpServletRequest request, UserDto dto) {

		Map<String, Object> map = new HashMap<String, Object>();
		UserDto userDto = userService.authentication(dto);

		HttpSession session = request.getSession();
		session.setAttribute("userDto", userDto);
		UserDto user = (UserDto) session.getAttribute("userDto");
		if (user != null) {
			map.put("status", "200");
			map.put("message", user);
		} else {
			map.put("status", "400");
			map.put("message", user);
		}

		return map;

	}

	/*
	 * This method for Register user
	 * 
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Map<String, Object> getRegisterUser(RegisterUserDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userService.register(dto)) {
			map.put("status", "200");
			map.put("message", "Your Registration Successful");
		} else {
			map.put("status", "400");
			map.put("message", "Your Registration failed");
		}

		return map;

	}

	@RequestMapping(value = "/getUserData", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Map<String, Object> getUserData(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if (userDto != null){
		map.put("status", "200");
		map.put("message", userDto);
		}
		else {
			map.put("status", "400");
			map.put("message", userDto);
			
		}
		return map;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody Map<String,Object> getLogout(HttpServletRequest request)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session.invalidate();
		
		map.put("status", "200");
		map.put("message", "You are logout Successfully");
		
		return map;
		
	}
	

}
