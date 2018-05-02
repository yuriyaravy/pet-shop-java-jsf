package com.senla.petshop.model.animal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senla.petshop.model.Base;

@Entity
@Table(name = "animals")
public class Animal extends Base {

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "animal_type_id")
	private AnimalType type;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "animal_info_id")
	private AnimalInfo info;

	public Animal() {

	}

	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
		this.type = type;
	}

	public AnimalInfo getInfo() {
		return info;
	}

	public void setInfo(AnimalInfo info) {
		this.info = info;
	}

}
