package com.mivim.dao;

import com.mivim.dto.OrdersDto;

public interface OrderDao {

	int placeOrder(OrdersDto dto);

}
