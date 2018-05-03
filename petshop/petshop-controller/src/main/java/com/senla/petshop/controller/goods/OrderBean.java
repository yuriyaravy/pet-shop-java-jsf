package com.senla.petshop.controller.goods;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.senla.petshop.api.service.goods.OrderService;
import com.senla.petshop.model.goods.Order;

@ManagedBean(name = "orderBean")
@RequestScoped
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{orderService}")
	private OrderService orderService;

	private Order order;
	private List<Order> orders;

	@PostConstruct
	public void init() {
		orders = orderService.orderWithCustomer();
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
