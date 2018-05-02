package com.senla.petshop.model.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.senla.petshop.model.Base;

@Entity
@Table(name = "address")
public class Address extends Base {

	@Column
	private String city;

	@Column
	private String street;

	@Column
	private Integer apartment;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getApartment() {
		return apartment;
	}

	public void setApartment(Integer apartment) {
		this.apartment = apartment;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
