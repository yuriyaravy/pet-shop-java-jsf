package com.senla.petshop.controller.person;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.senla.petshop.model.person.Customer;
import com.senla.petshop.model.person.Person;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{userDetailsService}")
	private UserDetailsService userDetailsService;

	private Person person;

	public Person checkPerson(String username) {
		return (Person) userDetailsService.loadUserByUsername(username);
	}

	public Person getPerson() {
		// if(person == null) {
		// person = new Customer();
		// }
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

}
