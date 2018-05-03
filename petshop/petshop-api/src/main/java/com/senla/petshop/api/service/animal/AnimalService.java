package com.senla.petshop.api.service.animal;

import java.util.List;

import com.senla.petshop.model.animal.Animal;

public interface AnimalService {

	Animal getAnimalById(Integer id);

	void createAnimal(Animal animal);

	List<Animal> getAnimalAndInfoAndType();

	List<Animal> getAll();

}
