package com.senla.petshop.api.service.person;

import com.senla.petshop.model.person.Authenticator;

public interface AuthenticatorService {

	Authenticator getAuthenticatorByLoginAndPassword(String login, String password);

	Integer getAuthenticatorId(String login, String password);

	void persistAuthenticator(Authenticator authen);

}
