package com.senla.petshop.model.person;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.senla.petshop.model.goods.Replenishment;

@Entity
@DiscriminatorValue("ROLE_ADMIN")
public class Admin extends Person {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admin", cascade = CascadeType.ALL)
	private List<Replenishment> replem;

	public Admin() {

	}

	public List<Replenishment> getReplem() {
		return replem;
	}

	public void setReplem(List<Replenishment> replem) {
		this.replem = replem;
	}

}
