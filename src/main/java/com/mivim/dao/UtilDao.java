package com.mivim.dao;

import java.util.List;

import com.mivim.dto.ItemsDto;
import com.mivim.dto.UtilDto;

public interface UtilDao {

	List<ItemsDto> getAllItems();

	List<ItemsDto> getItemById(UtilDto dto);

}
