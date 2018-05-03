package com.senla.petshop.controller.person;

import com.senla.petshop.api.service.person.CustomerService;
import com.senla.petshop.model.person.Customer;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "customerBean")
@RequestScoped
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{customerService}")
	private CustomerService customerService;

	private Customer customer;
	private List<Customer> customerList;

	@PostConstruct
	public void init() {
		customerList = customerService.customerWithOrder();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
