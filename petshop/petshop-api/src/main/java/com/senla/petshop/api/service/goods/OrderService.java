package com.senla.petshop.api.service.goods;

import java.util.List;

import com.senla.petshop.model.goods.Order;

public interface OrderService {

	List<Order> orderWithCustomer();

}
