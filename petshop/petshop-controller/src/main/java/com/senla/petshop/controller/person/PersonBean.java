package com.senla.petshop.controller.person;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.senla.petshop.api.service.person.PersonService;
import com.senla.petshop.model.enums.Role;
import com.senla.petshop.model.person.Address;
import com.senla.petshop.model.person.Authenticator;
import com.senla.petshop.model.person.Customer;
import com.senla.petshop.model.person.Person;

@ManagedBean(name = "personBean")
@RequestScoped
public class PersonBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Person person;
	private Authenticator authenticator;
	private Address address;
	private Role role;

	@ManagedProperty(value = "#{personService}")
	private PersonService personService;

	@ManagedProperty(value = "#{userDetailsService}")
	private UserDetailsService userDetailsService;

	public Authenticator getAuthenticator() {
		if (authenticator == null) {
			authenticator = new Authenticator();
		}
		return authenticator;
	}

	public Address getAddress() {
		if (address == null) {
			address = new Address();
		}
		return address;
	}

	public Person getPerson() {
		if (person == null) {
			person = new Customer();
		}
		return person;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public void persistPerson(Person person) {
		person.setAunthenticator(this.authenticator);
		person.setAddress(this.address);
		personService.persistPerson(person);
	}

	public Person checkPerson(String username) {
		return (Person) userDetailsService.loadUserByUsername(username);
	}

}
