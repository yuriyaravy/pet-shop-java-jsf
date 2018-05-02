package com.senla.petshop.api.dao.animal;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.animal.Animal;

public interface AnimalDao extends GenericDao<Animal> {

	List<Animal> getAnimalAndInfoAndType();

}
