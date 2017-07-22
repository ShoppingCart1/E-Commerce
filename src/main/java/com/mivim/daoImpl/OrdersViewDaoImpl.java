package com.mivim.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mivim.dao.OrdersViewDao;
import com.mivim.data.custom.dao.OrderViewMapper;
import com.mivim.data.custom.model.OrderView;
import com.mivim.dto.OrderViewDto;

@Repository
@Resource(name = "ordersViewDaoImpl")
public class OrdersViewDaoImpl implements OrdersViewDao {

	@Autowired
	OrderViewMapper orderViewMapper;

	@Autowired
	@Qualifier("orderView")
	OrderView orderView;

	

	@Override
	public List<OrderView> getOrdersView(String userId) {
		List<OrderView> list = orderViewMapper.selectByExample(userId);
		return list;
	}

}
