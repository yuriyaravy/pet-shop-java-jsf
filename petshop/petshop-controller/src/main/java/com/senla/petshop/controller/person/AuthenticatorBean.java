package com.senla.petshop.controller.person;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.senla.petshop.api.service.person.AuthenticatorService;
import com.senla.petshop.model.person.Authenticator;

@ManagedBean(name = "authenticatorBean")
@RequestScoped
public class AuthenticatorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Authenticator authenticator;

	@ManagedProperty(value = "#{authenticatorService}")
	private AuthenticatorService authenticatorService;

	public Authenticator getAuthenticator() {
		return authenticator;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	public AuthenticatorService getAuthenticatorService() {
		return authenticatorService;
	}

	public void setAuthenticatorService(AuthenticatorService authenticatorService) {
		this.authenticatorService = authenticatorService;
	}

}
