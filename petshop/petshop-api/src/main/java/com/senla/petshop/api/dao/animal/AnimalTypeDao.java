package com.senla.petshop.api.dao.animal;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.animal.AnimalType;

public interface AnimalTypeDao extends GenericDao<AnimalType> {

	List<AnimalType> sortByQuantity();

	List<AnimalType> sortByVariaty();

	List<AnimalType> getByVariaty(String variaty);

}
