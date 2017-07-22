package com.mivim.service;

import java.util.List;

import com.mivim.data.custom.model.OrderView;
import com.mivim.dto.OrderViewDto;

public interface OrdersViewService {

	List<OrderView> getOrdersView(String string);

}
