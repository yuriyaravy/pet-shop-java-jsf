package com.senla.petshop.api.service.person;

import java.util.List;

import com.senla.petshop.model.person.Customer;

public interface CustomerService {

	Customer getCustomerById(Integer id);

	List<Customer> sortCustomerByName();

	void deleteCustomer(Customer customer);

	void registrationCustomer(Customer customer);

	void addCustomer(Customer customer);

	List<Customer> customerWithOrder();

	void update(Customer customer);

	List<Customer> getAllCustomer();

	Customer customerByIdWithPets(Integer id);

}
