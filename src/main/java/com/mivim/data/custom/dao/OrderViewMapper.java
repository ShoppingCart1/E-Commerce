package com.mivim.data.custom.dao;

import java.util.List;

import com.mivim.data.custom.model.OrderView;


public interface OrderViewMapper {

	List<OrderView> selectByExample(String userId);

}
