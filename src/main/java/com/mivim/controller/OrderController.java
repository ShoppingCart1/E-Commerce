package com.mivim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mivim.dto.OrdersDto;
import com.mivim.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/placeOrder",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody String placeOrder(@RequestBody OrdersDto ordersDto)
	{
		//Map<String,Object> map=new HashMap<String,Object>();
		
	boolean flag=orderService.placeOrder(ordersDto);

		return null;
		
	}
}
