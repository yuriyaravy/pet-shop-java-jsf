package com.senla.petshop.controller.person;

import com.senla.petshop.api.service.person.CustomerService;
import com.senla.petshop.model.person.Customer;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "customer")
@RequestScoped
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{customerServise}")
	private CustomerService customerService;

	private Customer customer;
	private List<Customer> customerList;

	public Customer getCustomer() {
		if (customer == null) {
			int id = 1;
			customer = customerService.getCustomerById(id);
		}
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomerList() {
		if (customerList == null) {
			customerList = customerService.getCustomer();
		}
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
