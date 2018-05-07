package com.senla.petshop.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.person.PersonDao;
import com.senla.petshop.api.service.person.PersonService;
import com.senla.petshop.model.person.Authenticator;
import com.senla.petshop.model.person.Person;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Override
	public Person getPersonById(Integer id) {
		return personDao.getById(id);
	}

	@Override
	public Person getPersonByAuthenticator(Authenticator authenticator) {
		return personDao.getPersonByAuthenticator(authenticator);
	}

	@Override
	public void persistPerson(Person person) {
		personDao.create(person);
	}

}
