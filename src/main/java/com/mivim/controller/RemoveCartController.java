package com.mivim.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mivim.dto.AddCartDto;
import com.mivim.dto.UserDto;

@Controller
public class RemoveCartController {
   
	@RequestMapping(value="/removeCartItem",method=RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public @ResponseBody Set<AddCartDto> removeCartItem(HttpServletRequest request,AddCartDto dto) {
		HttpSession session = request.getSession();UserDto userDto=(UserDto) session.getAttribute("userDto");
		String userId= userDto.getId();
		
		Set<AddCartDto> removeCartDtos;

		removeCartDtos = (Set<AddCartDto>)session.getAttribute(userId);
		removeCartDtos.remove(dto);
		session.removeAttribute(userId);
		session.setAttribute(userId, removeCartDtos);
		Set<AddCartDto> sessioncart=(Set<AddCartDto>)session.getAttribute(userId);
		
		return sessioncart;
		
		
		
		
	}
}
