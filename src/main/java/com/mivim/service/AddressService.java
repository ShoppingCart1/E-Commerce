package com.mivim.service;

import java.util.List;

import com.mivim.dto.AddressCartDto;
import com.mivim.dto.AddressDto;
import com.mivim.dto.OrdersDto;

public interface AddressService {
	
	
	public List<OrdersDto> saveAddress(AddressCartDto dto);

}
