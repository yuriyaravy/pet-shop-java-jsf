package com.senla.petshop.api.service.animal;

import com.senla.petshop.model.animal.Animal;

public interface AnimalService {

	Animal getAnimalById(Integer id);

	void createAnimal(Animal animal);

}
