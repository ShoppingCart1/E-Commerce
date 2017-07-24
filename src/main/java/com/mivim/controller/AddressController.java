package com.mivim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mivim.dto.AddressCartDto;
import com.mivim.dto.AddressDto;
import com.mivim.dto.OrderItemDto;
import com.mivim.dto.OrdersDto;
import com.mivim.dto.UserDto;
import com.mivim.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	@Qualifier("addressServiceImpl")
	AddressService addressService;

	@RequestMapping(value = "/address", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<OrdersDto> sendAddress(@RequestBody AddressCartDto addressCartDto,
			HttpServletRequest request) {

		HttpSession session = request.getSession();

		UserDto userDto = (UserDto) session.getAttribute("userDto");

		AddressDto addressdto = addressCartDto.getAddressDto();
		addressdto.setUserId(userDto.getId());
		List<OrderItemDto> orderItemDto = addressCartDto.getOrderItemDto();
		
		boolean flag = addressService.saveAddress(addressdto);
		if(flag)
		{
			addressdto=null;
		}
		List<OrdersDto> list = addressService.getData(orderItemDto,userDto.getId());

		return list;

	}

}
