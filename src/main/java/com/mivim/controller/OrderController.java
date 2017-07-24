package com.mivim.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mivim.dto.OrdersDto;
import com.mivim.dto.UserDto;
import com.mivim.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/placeOrder",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody Map<String,Object> placeOrder(@RequestBody OrdersDto ordersDto,HttpServletRequest request)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		
		HttpSession session=request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		String userId=userDto.getId();
		
	boolean flag=orderService.placeOrder(ordersDto);
	if(flag)
	{
		session.removeAttribute(userId);
		map.put("status", "200");
		map.put("message", "your order is placed");
	}
	else
	{
		map.put("status", "400");
		map.put("message", "your order is not placed");
	}

		return map;
		
	}
}
