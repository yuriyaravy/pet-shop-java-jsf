package com.senla.petshop.controller.animal;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.senla.petshop.api.service.animal.AnimalInfoService;
import com.senla.petshop.api.service.animal.AnimalService;
import com.senla.petshop.api.service.animal.AnimalTypeService;
import com.senla.petshop.model.animal.Animal;
import com.senla.petshop.model.animal.AnimalInfo;
import com.senla.petshop.model.animal.AnimalType;

@ManagedBean(name = "animalBean")
@RequestScoped
public class AnimalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{animalService}")
	private AnimalService animalService;

	@ManagedProperty(value = "#{animalTypeService}")
	private AnimalTypeService animalTypeService;

	@ManagedProperty(value = "#{animalInfoService}")
	private AnimalInfoService animalInfoService;

	private Animal animal;
	private AnimalInfo animalInfo;
	private AnimalType animalType;
	private List<AnimalInfo> amimalsInfo;
	private List<Animal> animals;

	@PostConstruct
	public void init() {
		amimalsInfo = animalInfoService.getAll();
		animals = animalService.getAnimalAndInfoAndType();
	}

	public void deleteAnimalInf(AnimalInfo info) {
		animalInfoService.deleteAnimalInf(info);
	}

	public void persistAnimal() {
		Animal animal = new Animal();
		animal.setInfo(this.animalInfo);
		animal.setType(this.animalType);
		animalService.createAnimal(animal);
	}

	public List<AnimalInfo> getAmimalsInfo() {
		return amimalsInfo;
	}

	public void setAmimalsInfo(List<AnimalInfo> amimalsInfo) {
		this.amimalsInfo = amimalsInfo;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public AnimalService getAnimalService() {
		return animalService;
	}

	public void setAnimalTypeService(AnimalTypeService animalTypeService) {
		this.animalTypeService = animalTypeService;
	}

	public void setAnimalInfoService(AnimalInfoService animalInfoService) {
		this.animalInfoService = animalInfoService;
	}

	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public Animal getAnimal() {
		if (animal == null) {
			animal = new Animal();
		}
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public AnimalInfo getAnimalInfo() {
		if (animalInfo == null) {
			animalInfo = new AnimalInfo();
		}
		return animalInfo;
	}

	public void setAnimalInfo(AnimalInfo animalInfo) {
		this.animalInfo = animalInfo;
	}

	public AnimalType getAnimalType() {
		if (animalType == null) {
			animalType = new AnimalType();
		}
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

}
