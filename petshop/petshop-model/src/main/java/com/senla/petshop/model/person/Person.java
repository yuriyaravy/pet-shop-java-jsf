package com.senla.petshop.model.person;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senla.petshop.model.Base;
import com.senla.petshop.model.enums.Role;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "person")
@DiscriminatorColumn(name = "type")
public abstract class Person extends Base {

	@Column(nullable = false, unique = true)
	private String name;

	@Column
	private String surname;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aunthenticator_id")
	private Authenticator aunthenticator;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "home_address_id")
	private Address address;

	public Person() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Authenticator getAunthenticator() {
		return aunthenticator;
	}

	public void setAunthenticator(Authenticator aunthenticator) {
		this.aunthenticator = aunthenticator;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
