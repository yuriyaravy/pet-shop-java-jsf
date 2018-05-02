package com.senla.petshop.model.goods;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senla.petshop.model.Base;
import com.senla.petshop.model.person.Address;

@Entity
@Table(name = "product_details")
public class ProductDetail extends Base {

	@Column(name = "name_of_organization")
	private String name;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "producer_address")
	private Address address;

	public ProductDetail() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
