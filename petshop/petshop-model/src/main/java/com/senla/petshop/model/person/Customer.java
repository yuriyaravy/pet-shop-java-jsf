package com.senla.petshop.model.person;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.senla.petshop.model.animal.Animal;
import com.senla.petshop.model.goods.Order;

@Entity
@DiscriminatorValue("ROLE_USER")
public class Customer extends Person {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "info", cascade = CascadeType.ALL)
	private List<Animal> pets;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> order;

	public Customer() {

	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public List<Animal> getPets() {
		return pets;
	}

	public void setPets(List<Animal> pets) {
		this.pets = pets;
	}

}
