package com.mivim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mivim.dto.ItemsDto;
import com.mivim.dto.UtilDto;
import com.mivim.service.UtilService;

@Controller
public class UtilController {

	@Autowired(required=true)
	@Qualifier("utilServiceImpl")
	UtilService utilService;
	
	@RequestMapping(value="/getItemsData",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody List<ItemsDto> getItemsData()
	{
		List<ItemsDto> items=utilService.getItemDetails();
		
		return items;
	}
	
	@RequestMapping(value="/getItemDataById",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody List<ItemsDto> getItemData(UtilDto dto)
	{
		List<ItemsDto> item=utilService.getItemView(dto);

		return item;
		
	}
}
