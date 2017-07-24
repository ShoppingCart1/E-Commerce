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
public class AddCartController {

	@RequestMapping(value = "/addcart", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Set<AddCartDto> getAddCartData(HttpServletRequest request, AddCartDto dto) {

		HttpSession session = request.getSession();

		UserDto userDto = (UserDto) session.getAttribute("userDto");
		String userId = userDto.getId();
		Set<AddCartDto> addCartDtos = null;

		addCartDtos = (Set<AddCartDto>) session.getAttribute("cart");
		if (addCartDtos == null) {
			addCartDtos = new HashSet<AddCartDto>();
			session.setAttribute("cart", addCartDtos);
		}

		AddCartDto cartDto = new AddCartDto();
		cartDto.setId(dto.getId());
		cartDto.setItemName(dto.getItemName());
		cartDto.setItemDescription(dto.getItemDescription());
		cartDto.setUnitPrice(dto.getUnitPrice());
		cartDto.setInventary(dto.getInventary());
		addCartDtos.add(cartDto);
		session.setAttribute(userId, addCartDtos);
		Set<AddCartDto> sessioncart = (Set<AddCartDto>) session.getAttribute(userId);

		return sessioncart;

	}

	@RequestMapping(value = "/getCart", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Set<AddCartDto> getCartData(HttpServletRequest request) {

		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		String userId = userDto.getId();
		Set<AddCartDto> sessioncart = (Set<AddCartDto>) session.getAttribute(userId);
		return sessioncart;
	}

}
