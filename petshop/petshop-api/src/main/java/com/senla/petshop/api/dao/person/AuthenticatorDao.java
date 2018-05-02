package com.senla.petshop.api.dao.person;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.person.Authenticator;

public interface AuthenticatorDao extends GenericDao<Authenticator> {

	Authenticator getAunthenticator(String login, String password);

	Integer checkAunthenticator(String login, String password);

}
