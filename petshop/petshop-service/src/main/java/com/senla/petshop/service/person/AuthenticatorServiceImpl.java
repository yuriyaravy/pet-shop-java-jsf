package com.senla.petshop.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.person.AuthenticatorDao;
import com.senla.petshop.api.service.person.AuthenticatorService;
import com.senla.petshop.model.person.Authenticator;

@Service("authenticatorService")
@Transactional
public class AuthenticatorServiceImpl implements AuthenticatorService {

	@Autowired
	private AuthenticatorDao authenticatorDao;

	@Override
	public void persistAuthenticator(Authenticator authen) {
		authenticatorDao.create(authen);
	}

	@Override
	public Authenticator getAuthenticatorById(Integer id) {
		return authenticatorDao.getById(id);
	}

	@Override
	public Authenticator getAuthenticatorByLoginAndPassword(String login, String password) {
		return authenticatorDao.getAunthenticator(login, password);
	}

	@Override
	public Integer getAuthenticatorId(String login, String password) {
		return authenticatorDao.checkAunthenticator(login, password);
	}

}
