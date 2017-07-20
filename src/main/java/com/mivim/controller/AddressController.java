package com.mivim.controller;

import java.util.List;

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
import com.mivim.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	@Qualifier("addressServiceImpl")
	AddressService addressService;

	@RequestMapping(value = "/address", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<OrdersDto> sendAddress(@RequestBody AddressCartDto addressCartDto) {
		AddressDto addressdto = addressCartDto.getAddressDto();
		List<OrderItemDto> orderItemDto = addressCartDto.getOrderItemDto();
		boolean flag = addressService.saveAddress(addressdto);

		List<OrdersDto> list = addressService.getData(orderItemDto);

		return list;

	}

}
