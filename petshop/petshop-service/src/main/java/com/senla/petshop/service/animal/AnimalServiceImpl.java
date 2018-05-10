package com.senla.petshop.service.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.animal.AnimalDao;
import com.senla.petshop.api.service.animal.AnimalService;
import com.senla.petshop.model.animal.Animal;

@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalDao animalDao;

	@Override
	public List<Animal> getAll() {
		return animalDao.getAll();
	}

	@Override
	public List<Animal> getAnimalAndInfoAndTypeNullCustomer() {
		return animalDao.getAnimalAndInfoAndTypeNullCustomer();
	}

	@Override
	public List<Animal> getAnimalAndInfoAndType() {
		return animalDao.getAnimalAndInfoAndType();
	}

	@Override
	public void createAnimal(Animal animal) {
		animalDao.create(animal);
	}

	@Override
	public Animal getAnimalById(Integer id) {
		return animalDao.getById(id);
	}

}
