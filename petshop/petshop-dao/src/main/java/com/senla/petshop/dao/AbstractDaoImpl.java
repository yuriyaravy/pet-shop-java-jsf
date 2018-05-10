package com.senla.petshop.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.senla.petshop.api.dao.GenericDao;

public class AbstractDaoImpl<T> implements GenericDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> clazz;

	public AbstractDaoImpl(Class<T> clazz) {
		this.clazz = clazz;

	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Class<T> getClazz() {
		return clazz;
	}

	@Override
	public void create(T object) {
		sessionFactory.getCurrentSession().save(object);

	}

	@Override
	public void delete(T object) {
		sessionFactory.getCurrentSession().delete(object);

	}

	@Override
	public void update(T object) {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public T getById(Integer id) {
		return (T) sessionFactory.getCurrentSession().get(getClazz(), id);
	}

	@Override
	public List<T> getAll(String... sort) {
		if (sort.length > 0 | sort == null) {
			CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<T> criteriaQuery = builder.createQuery(getClazz());
			Root<T> root = criteriaQuery.from(getClazz());
			criteriaQuery.select(root);
			criteriaQuery.orderBy(builder.asc(root.get(sort[0])));
			return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
		} else {
			CriteriaQuery<T> query = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(getClazz());
			query.select(query.from(getClazz()));
			return sessionFactory.getCurrentSession().createQuery(query).getResultList();
		}
	}
}
