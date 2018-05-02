package com.senla.petshop.api.dao.goods;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.goods.Order;

public interface OrderDao extends GenericDao<Order> {

	List<Order> sortByStart();

	List<Order> sortByEnd();

	List<Order> getProcessing();

	List<Order> getCanceled();

	List<Order> getCompleted();

}
