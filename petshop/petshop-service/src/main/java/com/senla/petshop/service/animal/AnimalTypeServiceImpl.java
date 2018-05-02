package com.senla.petshop.service.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.animal.AnimalTypeDao;
import com.senla.petshop.api.service.animal.AnimalTypeService;
import com.senla.petshop.model.animal.AnimalType;

@Service("animalTypeService")
@Transactional
public class AnimalTypeServiceImpl implements AnimalTypeService {

	@Autowired
	private AnimalTypeDao animalTypeDao;

	@Override
	public void createAnimalType(AnimalType animalType) {
		animalTypeDao.create(animalType);
	}

}
