package com.senla.petshop.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.goods.OrderDao;
import com.senla.petshop.api.service.goods.OrderService;
import com.senla.petshop.model.goods.Order;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Order> orderWithCustomer() {
		return orderDao.orderWithCustomer();
	}

}
