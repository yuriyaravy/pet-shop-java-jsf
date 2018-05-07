package com.senla.petshop.dao.goods;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.goods.OrderDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.enums.OrderStatus;
import com.senla.petshop.model.goods.Order;
import com.senla.petshop.model.person.Customer;

@Repository
public class OrderDaoImpl extends AbstractDaoImpl<Order> implements OrderDao {

	private static final String START = "start";
	private static final String END = "end";
	private static final String STATUS = "status";

	public OrderDaoImpl() {
		super(Order.class);
	}

	@Override
	public List<Order> orderWithCustomer() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		Fetch<Order, Customer> orderCustomer = root.fetch("customer");
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<Order> getCompleted() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		query.select(root).where(builder.equal(root.get(STATUS), OrderStatus.COMPLEATE.toString()));
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<Order> getCanceled() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		query.select(root).where(builder.equal(root.get(STATUS), OrderStatus.CANCELED.toString()));
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<Order> getProcessing() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		query.select(root).where(builder.equal(root.get(STATUS), OrderStatus.PROCESSING.toString()));
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<Order> sortByStart() {
		return getAll(START);
	}

	@Override
	public List<Order> sortByEnd() {
		return getAll(END);

	}

}
