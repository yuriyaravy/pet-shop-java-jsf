package com.senla.petshop.dao.person;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.person.CustomerDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.animal.Animal;
import com.senla.petshop.model.goods.Order;
import com.senla.petshop.model.person.Address;
import com.senla.petshop.model.person.Authenticator;
import com.senla.petshop.model.person.Customer;

@Repository
public class CustomerDaoImpl extends AbstractDaoImpl<Customer> implements CustomerDao {

	private static final String ADRRESS = "adress";

	public CustomerDaoImpl() {
		super(Customer.class);
	}

	@Override
	public Customer customerByIdWithPets(Integer id) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
		Root<Customer> root = query.from(Customer.class);
		Fetch<Customer, Animal> customerOrder = root.fetch("pets");
		query.select(root).where(builder.equal(root.get("id"), id));
		return getSession().createQuery(query).getSingleResult();
	}

	@Override
	public List<Customer> customerWithOrder() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
		Root<Customer> root = query.from(Customer.class);
		Fetch<Customer, Order> customerOrder = root.fetch("order");
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<Customer> getCustomerAndAddress() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
		Root<Customer> rootCustomer = query.from(Customer.class);
		Fetch<Customer, Address> fetch = rootCustomer.fetch(ADRRESS);
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<Customer> sortByName() {
		return getAll("name");
	}

	@Override
	public List<Customer> sortByAdress() {
		return getAll(ADRRESS);
	}

	@Override
	public List<Customer> sortByPet() {
		return getAll("pet");
	}

}
