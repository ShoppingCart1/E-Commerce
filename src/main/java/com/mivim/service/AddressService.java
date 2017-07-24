package com.mivim.service;

import java.util.List;

import com.mivim.dto.AddressCartDto;
import com.mivim.dto.AddressDto;
import com.mivim.dto.OrderItemDto;
import com.mivim.dto.OrdersDto;

public interface AddressService {
	
	
	public boolean saveAddress(AddressDto addressdto);

	public List<OrdersDto> getData(List<OrderItemDto> orderItemDto, String string);

}
