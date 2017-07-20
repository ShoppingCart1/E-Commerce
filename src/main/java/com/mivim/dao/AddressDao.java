package com.mivim.dao;

import com.mivim.dto.AddressDto;

public interface AddressDao {

	boolean sendAddress(AddressDto addressdto);
	public String getShippingAddressId();
	public int saveShippingAddress();

}
