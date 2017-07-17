package com.mivim.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mivim.dto.AddCartDto;

 @Controller
public class RemoveCartController {

	 
	 @RequestMapping(value = "/removecart", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
		public @ResponseBody Set<AddCartDto> getRemoveCartData(HttpServletRequest request,AddCartDto dto)
		{
			
			HttpSession session = request.getSession();
			Set<AddCartDto> removeCartDtos = null;

			removeCartDtos = (Set<AddCartDto>) session.getAttribute("addcart");
			

			AddCartDto cartDto = new AddCartDto();
			cartDto.setId(dto.getId());
			cartDto.setItemName(dto.getItemName());
			cartDto.setItemDescription(dto.getItemDescription());
			cartDto.setUnitPrice(dto.getUnitPrice());
			cartDto.setInventary(dto.getInventary());
			removeCartDtos.remove(cartDto);
			session.setAttribute("removecart", removeCartDtos);
			Set<AddCartDto> sessioncart=(Set<AddCartDto>)session.getAttribute("removecart");
			
			return sessioncart;
			
		}
		
		
}
