package com.mivim.service;

import java.util.List;

import com.mivim.dto.ItemsDto;
import com.mivim.dto.UtilDto;

public interface UtilService {
	
	
	public List<ItemsDto> getItemDetails();

	public List<ItemsDto> getItemView(UtilDto dto);

	

}
