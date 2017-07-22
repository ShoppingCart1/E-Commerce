package com.mivim.dao;

import java.util.List;

import com.mivim.data.custom.model.OrderView;
import com.mivim.dto.OrderViewDto;

public interface OrdersViewDao {

	List<OrderView> getOrdersView(String userId);

}
