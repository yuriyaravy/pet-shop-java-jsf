package com.senla.petshop.dao.person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.person.AuthenticatorDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.person.Authenticator;

@Repository
public class AuthenticatorDaoImpl extends AbstractDaoImpl<Authenticator> implements AuthenticatorDao {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	public AuthenticatorDaoImpl() {
		super(Authenticator.class);
	}

	@Override
	public Integer checkAunthenticator(String login, String password) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Authenticator> query = builder.createQuery(Authenticator.class);
		Root<Authenticator> root = query.from(Authenticator.class);
		query.select(root)
				.where(builder.and(builder.equal(root.get(LOGIN), login), builder.equal(root.get(PASSWORD), password)));
		Authenticator checked = getSession().createQuery(query).getSingleResult();
		return checked.getId();
	}

	@Override
	public Authenticator getAunthenticator(String login, String password) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Authenticator> query = builder.createQuery(Authenticator.class);
		Root<Authenticator> root = query.from(Authenticator.class);
		query.select(root)
				.where(builder.and(builder.equal(root.get(LOGIN), login), builder.equal(root.get(PASSWORD), password)));
		return getSession().createQuery(query).getSingleResult();
	}

}
