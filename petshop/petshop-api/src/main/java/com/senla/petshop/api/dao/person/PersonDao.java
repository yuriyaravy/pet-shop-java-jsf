package com.senla.petshop.api.dao.person;

import com.senla.petshop.model.person.Person;

public interface PersonDao {

	Person findPersonByName(String name);

}
