package com.senla.petshop.api.service.animal;

import java.util.List;

import com.senla.petshop.model.animal.AnimalInfo;

public interface AnimalInfoService {

	void createAnimalInfo(AnimalInfo animalInfo);

	List<AnimalInfo> getAll();

}
