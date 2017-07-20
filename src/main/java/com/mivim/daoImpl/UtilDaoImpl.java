package com.mivim.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mivim.dao.UtilDao;
import com.mivim.data.dao.ItemMapper;
import com.mivim.data.model.Item;
import com.mivim.data.model.ItemExample;
import com.mivim.dto.ItemsDto;
import com.mivim.dto.UtilDto;

@Repository
@Resource(name = "utilDaoImpl")
public class UtilDaoImpl implements UtilDao {

	@Autowired
	ItemMapper itemMapper;

	@Autowired
	@Qualifier("item")
	Item item;

	@Autowired
	@Qualifier("itemExample")
	ItemExample itemExample;

	@Override
	public List<ItemsDto> getAllItems() {
		List<ItemsDto> newList = new ArrayList<ItemsDto>();

		itemExample.setDistinct(true);
		itemExample.or().andStatusEqualTo(1);
		List<Item> list = itemMapper.selectByExample(itemExample);

		for (Item item : list) {
			ItemsDto itemsDto = new ItemsDto();
			itemsDto.setId(item.getId());
			itemsDto.setItemName(item.getItemName());
			itemsDto.setItemDescription(item.getItemDescription());
			itemsDto.setUnitPrice(item.getUnitPrice());
			newList.add(itemsDto);

		}
		itemExample.clear();
		return newList;
	}

	@Override
	public List<ItemsDto> getItemById(UtilDto dto) {
		
		List<ItemsDto> newList = new ArrayList<ItemsDto>();
		itemExample.or().andIdEqualTo(dto.getId());
		
		List<Item> list = itemMapper.selectByExample(itemExample);

		for (Item item : list) {
			
			ItemsDto itemsDto = new ItemsDto();
			itemsDto.setId(item.getId());
			itemsDto.setItemName(item.getItemName());
			itemsDto.setItemDescription(item.getItemDescription());
			itemsDto.setUnitPrice(item.getUnitPrice());
			newList.add(itemsDto);

		}

		return newList;
	}

}
