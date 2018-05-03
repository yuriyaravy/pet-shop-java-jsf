package com.senla.petshop.api.dao.person;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.person.Authenticator;
import com.senla.petshop.model.person.Customer;

public interface CustomerDao extends GenericDao<Customer> {

	List<Customer> sortByName();

	List<Customer> sortByAdress();

	List<Customer> sortByPet();

	Customer getCustomerByAuthenticator(Authenticator authenticator);

	List<Customer> getCustomerAndAddress();

	List<Customer> customerWithOrder();

}
