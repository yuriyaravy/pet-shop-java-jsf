package com.senla.petshop.model.animal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senla.petshop.model.Base;

@Entity
@Table(name = "animal_type")
public class AnimalType extends Base {

	@Column(nullable = false)
	private String variety;

	@OneToOne(mappedBy = "type", cascade = CascadeType.ALL)
	private Animal animal;

	public AnimalType() {
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
