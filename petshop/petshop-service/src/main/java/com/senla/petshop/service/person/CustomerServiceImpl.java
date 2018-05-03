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
	public List<Customer> customerWithOrder() {
		System.out.println("------customer with order -------");
		List<Customer> list = customerDao.customerWithOrder();
		if (list != null) {
			for (Customer cust : list) {
				System.out.println(cust.getOrder());
			}
		}

		return list;
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
	public List<Customer> getCustomer() {
		return customerDao.getAll();
	}

}
