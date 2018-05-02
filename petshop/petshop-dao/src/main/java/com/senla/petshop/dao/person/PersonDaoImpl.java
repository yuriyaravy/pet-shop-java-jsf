package com.senla.petshop.dao.person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.person.PersonDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.person.Person;

@Repository
public class PersonDaoImpl extends AbstractDaoImpl<Person> implements PersonDao {

	public PersonDaoImpl() {
		super(Person.class);
	}

	@Override
	public Person findPersonByName(String name) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Person> query = builder.createQuery(Person.class);
		Root<Person> root = query.from(Person.class);
		query.select(root).where(builder.equal(root.get("name"), name));
		return getSession().createQuery(query).getSingleResult();
	}

}
