package com.mivim.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mivim.dto.ItemsDto;
import com.mivim.dto.UtilDto;
import com.mivim.service.UtilService;



@Service
@Resource(name="utilServiceImpl")
public class UtilServiceImpl implements UtilService {

	@Override
	public List<ItemsDto> getItemDetails() {
		
		return getData();
	}

	@Override
	public List<ItemsDto> getItemView(UtilDto dto) {
		List<ItemsDto> itemsData=getData();
		List<ItemsDto> item=new ArrayList<ItemsDto>();
		for(ItemsDto itemDto:itemsData)
		{
			if(itemDto.getId().equals(dto.getId()))
			{
				item.add(itemDto);
			}
		}
		return item;
	}
	
	
	public static List<ItemsDto> getData()
	{
		ItemsDto item1=new ItemsDto();
		item1.setId("1");
		item1.setItemName("Item1 Name");
		item1.setUnitPrice("14500");
		item1.setItemDescription("This is Item Description");
		ItemsDto item2=new ItemsDto();
		item2.setId("2");
		item2.setItemName("Item2 Name");
		item2.setUnitPrice("14500");
		item2.setItemDescription("This is Item Description");
		ItemsDto item3=new ItemsDto();
		item3.setId("3");
		item3.setItemName("Item3 Name");
		item3.setUnitPrice("14500");
		item3.setItemDescription("This is Item Description");
		ItemsDto item4=new ItemsDto();
		item4.setId("4");
		item4.setItemName("Item4 Name");
		item4.setUnitPrice("14500");
		item4.setItemDescription("This is Item Description");
		ItemsDto item5=new ItemsDto();
		item5.setId("5");
		item5.setItemName("Item5 Name");
		item5.setUnitPrice("14500");
		item5.setItemDescription("This is Item Description");
		ItemsDto item6=new ItemsDto();
		item6.setId("6");
		item6.setItemName("Item6 Name");
		item6.setUnitPrice("14500");
		item6.setItemDescription("This is Item Description");
		List<ItemsDto> list=new ArrayList<ItemsDto>();
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		list.add(item5);
		list.add(item6);
		return list;
		
	}

	
}
