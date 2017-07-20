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

@Controller
public class RemoveCartController {
   
	@RequestMapping(value="/removeCartItem",method=RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public @ResponseBody Set<AddCartDto> removeCartItem(HttpServletRequest request,AddCartDto dto) {
		HttpSession session = request.getSession();
		Set<AddCartDto> removeCartDtos;

		removeCartDtos = (Set<AddCartDto>)session.getAttribute("addcart");
		removeCartDtos.remove(dto);
		session.removeAttribute("addcart");
		session.setAttribute("addcart", removeCartDtos);
		Set<AddCartDto> sessioncart=(Set<AddCartDto>)session.getAttribute("addcart");
		
		return sessioncart;
		
		
		
		
	}
}
