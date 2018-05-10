package com.senla.petshop.service.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.person.CustomerDao;
import com.senla.petshop.api.service.person.CustomerService;
import com.senla.petshop.model.person.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer customerByIdWithPets(Integer id) {
		return customerDao.customerByIdWithPets(id);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public List<Customer> customerWithOrder() {
		return customerDao.customerWithOrder();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customerDao.getById(id);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.create(customer);
	}

	@Override
	public List<Customer> sortCustomerByName() {
		return customerDao.sortByName();
	}

	@Override
	public void registrationCustomer(Customer customer) {
		customerDao.create(customer);

	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.delete(customer);

	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAll();
	}

}
