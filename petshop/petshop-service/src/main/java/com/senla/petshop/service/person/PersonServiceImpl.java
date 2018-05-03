package com.senla.petshop.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.person.PersonDao;
import com.senla.petshop.api.service.person.PersonService;
import com.senla.petshop.model.person.Person;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	public void persistPerson(Person person) {
		personDao.create(person);
	}

}
