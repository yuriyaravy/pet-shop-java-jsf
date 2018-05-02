package com.senla.petshop.api.dao.animal;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.animal.AnimalInfo;

public interface AnimalInfoDao extends GenericDao<AnimalInfo> {

	List<AnimalInfo> sortByName();

	List<AnimalInfo> sortByWeight();

	List<AnimalInfo> sortByVaccionation();

	List<AnimalInfo> sortByAge();

	List<Object[]> getAnimalInfoAndOwner();

	List<AnimalInfo> getAnimalInfoSold();

}
