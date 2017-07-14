package com.mivim.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mivim.dto.AddressDto;

@Controller
public class AddressController {
	
	@RequestMapping(value="/saveAddress",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody  Map<String,Object> saveAddress(AddressDto dto)
	{
		return null;
		
	}

}
