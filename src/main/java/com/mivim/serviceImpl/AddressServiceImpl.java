package com.mivim.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mivim.dao.AddressDao;
import com.mivim.daoImpl.Utils;
import com.mivim.dto.AddressCartDto;
import com.mivim.dto.AddressDto;
import com.mivim.dto.OrderItemDto;
import com.mivim.dto.OrdersDto;
import com.mivim.service.AddressService;

@Service
@Resource(name="addressServiceImpl")
public class AddressServiceImpl implements AddressService {

	
	private static String orderId=Utils.getUUId();
	
	
	@Autowired
	private static AddressDao addressDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.mivim.service.AddressService#saveAdress(com.mivim.dto.AddressDto)
	 */
	public List<OrdersDto> saveAddress(AddressCartDto dto) {
		
		AddressDto addressdto=dto.getAddressDto();
		
		List<OrderItemDto> orderItemDto=dto.getOrderItemDto();
		
		boolean flag=addressDao.sendAddress(addressdto);
		if(flag)
		{
			addressDao.saveShippingAddress();
		}
		
		List<OrdersDto> list=getOrder(orderItemDto);
		
		return list;
	}
	
	
	
	
	public static List<OrdersDto> getOrder(List<OrderItemDto> dto)
	{
		List<OrdersDto> orders=new ArrayList<OrdersDto>();
		
		OrdersDto ordersDto=new OrdersDto();
		
		
		
		String subTotal = getSubTotal(dto);
		
		String shippingAddressId = addressDao.getShippingAddressId();
		
		List<OrderItemDto> listItems=getListItems(dto);
		ordersDto.setId(orderId);
		ordersDto.setUserId("1235");
		ordersDto.setSubTotal(subTotal);
		ordersDto.setGrandTotal(subTotal);
		ordersDto.setShippingAddressId(shippingAddressId);
		ordersDto.setListItems(listItems);
		
		orders.add(ordersDto);
		
		return orders;
		
	}
	
	private static List<OrderItemDto> getListItems(List<OrderItemDto> dto) {
		
		List<OrderItemDto> list=new ArrayList<OrderItemDto>();
		
		
		for(OrderItemDto orderItemDto:dto)
		{
			OrderItemDto orderDto=new OrderItemDto();
			
			Long totalPrice=(long) (Integer.parseInt(orderItemDto.getUnitPrice())*Integer.parseInt(orderItemDto.getQuantity()));
			String itemId= orderItemDto.getId();
			String quantity =orderItemDto.getQuantity();
			
			orderDto.setOrderDate(Utils.getDate().toString());
			orderDto.setItemId(itemId);
			orderDto.setQuantity(quantity);
			orderDto.setOrderId(orderId);
			orderDto.setTotalPrice(totalPrice.toString());
			
			
			list.add(orderDto);		
		}
		
		return list;
	}
	
	private static String getSubTotal(List<OrderItemDto> dto) {
		long obj = 0;
		for(OrderItemDto orderItemDto:dto)
		{
			obj=obj+(Integer.parseInt(orderItemDto.getQuantity())*Integer.parseInt(orderItemDto.getUnitPrice()));
		}
		
		return new Long(obj).toString();
	}
	

}
