package com.senla.petshop.api.dao.person;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.person.Person;

public interface PersonDao extends GenericDao<Person> {

	Person findPersonByName(String name);

}
