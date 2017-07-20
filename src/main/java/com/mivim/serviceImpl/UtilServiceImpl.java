package com.mivim.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mivim.dao.UtilDao;
import com.mivim.dto.ItemsDto;
import com.mivim.dto.UtilDto;
import com.mivim.service.UtilService;



@Service
@Resource(name="utilServiceImpl")
public class UtilServiceImpl implements UtilService {

	@Autowired
	@Qualifier("utilDaoImpl")
	UtilDao utilDao;
	
	
	
	@Override
	public List<ItemsDto> getItemDetails() {
		
		List<ItemsDto> list= utilDao.getAllItems();
		
		return list;
	}

	@Override
	public List<ItemsDto> getItemView(UtilDto dto) {
		List<ItemsDto> list= utilDao.getItemById(dto);
		return list;
	}
	
	

	
}
