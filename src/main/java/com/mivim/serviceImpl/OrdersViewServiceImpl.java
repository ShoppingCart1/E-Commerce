package com.mivim.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mivim.dao.OrdersViewDao;
import com.mivim.data.custom.model.OrderView;
import com.mivim.dto.OrderViewDto;
import com.mivim.service.OrdersViewService;



@Service
@Resource(name="ordersViewServiceImpl")
public class OrdersViewServiceImpl implements OrdersViewService{

	@Autowired
	@Qualifier("ordersViewDaoImpl")
	OrdersViewDao ordersViewDao;


	@Override
	public List<OrderView> getOrdersView(String userId) {
		List<OrderView> list=ordersViewDao.getOrdersView(userId);
		return list;

	}
}
