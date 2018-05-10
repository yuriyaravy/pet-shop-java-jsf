package com.senla.petshop.controller.person;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.senla.petshop.api.service.person.AuthenticatorService;
import com.senla.petshop.api.service.person.PersonService;
import com.senla.petshop.model.person.Admin;
import com.senla.petshop.model.person.Authenticator;
import com.senla.petshop.model.person.Person;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{userDetailsServiceImpl}")
	private UserDetailsService userDetailsService;

	@ManagedProperty(value = "#{personService}")
	private PersonService personService;

	@ManagedProperty(value = "#{authenticatorService}")
	private AuthenticatorService authenticatorService;

	private Person person;
	private Authenticator authenticator;

	public void checkPerson(Authenticator authenticator) {
		Integer authId = authenticatorService.getAuthenticatorId(authenticator.getLogin(), authenticator.getPassword());
		Person personDB = personService.getPersonById(authId);
		userDetailsService.loadUserByUsername(personDB.getName());
	}

	public Authenticator getAuthenticator() {
		if (authenticator == null) {
			authenticator = new Authenticator();
		}
		return authenticator;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	public Person getPerson() {
		if (person == null) {
			person = new Admin();
		}
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

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public AuthenticatorService getAuthenticatorService() {
		return authenticatorService;
	}

	public void setAuthenticatorService(AuthenticatorService authenticatorService) {
		this.authenticatorService = authenticatorService;
	}

}
