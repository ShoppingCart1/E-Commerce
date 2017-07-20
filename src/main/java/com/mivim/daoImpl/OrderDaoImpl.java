package com.mivim.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mivim.dao.OrderDao;
import com.mivim.data.dao.OrderitemMapper;
import com.mivim.data.dao.OrdersMapper;
import com.mivim.data.model.Orderitem;
import com.mivim.data.model.Orders;
import com.mivim.dto.OrderItemDto;
import com.mivim.dto.OrdersDto;
@Repository
@Resource(name="orderDaoImpl")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private OrderitemMapper orderitemMapper; 
	
	@Autowired
	@Qualifier("orderitem")
	Orderitem orderitem;
	
	@Autowired
	@Qualifier("orders")
	Orders orders;
	
	@Override
	public int placeOrder(OrdersDto dto) {
		int status= 0;
		orders.setBillingAddressId(null);
		orders.setGrandTotal(dto.getGrandTotal());
		orders.setId(dto.getId());
		orders.setPaymentMode(dto.getPaymentMode());
		orders.setShippingAddressId(dto.getShippingAddressId());
		orders.setSubTotal(dto.getSubTotal());
		orders.setUserId("1235");
		
		int val=ordersMapper.insert(orders);
		
		if(val!=0)
		{
			int val2= saveOrderItemList(dto);
			if(val2!=0)
			{
				status=1;
			}
		}
		
		return status;
	}

	private int saveOrderItemList(OrdersDto dto) {
		
		List<OrderItemDto> orderItemDto=dto.getListItems();
		int status = 0;
		for(OrderItemDto orderDto: orderItemDto)
		{
			orderitem.setId(Utils.getUUId());
			orderitem.setItemId(orderDto.getItemId());
			orderitem.setOrderId(dto.getId());
			orderitem.setOrderDate(orderDto.getOrderDate());
			orderitem.setTotalPrice(orderDto.getTotalPrice());
			orderitem.setQuantity(orderDto.getQuantity());
			orderitem.setUpdatedDate(Utils.getDate());
			orderitem.setStatus(Utils.getStatusCode());
			status=orderitemMapper.insert(orderitem);			
		}
		
		return status;
		
		
	}
	
	
	

}
