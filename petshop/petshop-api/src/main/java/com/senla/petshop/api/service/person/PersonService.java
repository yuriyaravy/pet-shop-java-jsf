package com.senla.petshop.api.service.person;

import com.senla.petshop.model.person.Authenticator;
import com.senla.petshop.model.person.Person;

public interface PersonService {

	void persistPerson(Person person);

	Person getPersonByAuthenticator(Authenticator authenticator);

	Person getPersonById(Integer id);

}
