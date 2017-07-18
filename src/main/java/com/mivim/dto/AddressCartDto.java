package com.mivim.dto;

import java.util.List;

public class AddressCartDto {
	
	List<OrderItemDto> orderItemDto;
	AddressDto addressDto;
	

	public List<OrderItemDto> getOrderItemDto() {
		return orderItemDto;
	}
	public void setOrderItemDto(List<OrderItemDto> orderItemDto) {
		this.orderItemDto = orderItemDto;
	}
	public AddressDto getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	
	
	
	

}
