package com.mivim.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mivim.dao.OrderDao;
import com.mivim.dto.OrdersDto;
import com.mivim.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	@Qualifier("orderDaoImpl")
	OrderDao orderDao;

	public boolean placeOrder(OrdersDto dto) {

		int status = orderDao.placeOrder(dto);

		if (status != 0)
			return true;
		else
			return false;
	}

}
