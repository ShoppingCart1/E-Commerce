package com.mivim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mivim.data.custom.model.OrderView;
import com.mivim.dto.OrderViewDto;
import com.mivim.dto.UserDto;
import com.mivim.service.OrdersViewService;

@Controller
public class OrdersViewController {

	
	@Autowired
	@Qualifier("ordersViewServiceImpl")
	OrdersViewService ordersViewService;
	
	
	@RequestMapping(value="/ordersview",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody List<OrderView> getOrdersView(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		List<OrderView> list=ordersViewService.getOrdersView(userDto.getId());
		
		return list;
		
	}
	
	
}
