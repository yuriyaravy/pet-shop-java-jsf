package com.senla.petshop.model.animal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.senla.petshop.model.Base;
import com.senla.petshop.model.person.Customer;

@Entity
@Table(name = "animal_info")
public class AnimalInfo extends Base {

	@Column
	private String name;

	@Column
	private Integer age;

	@Type(type = "yes_no")
	@Column(nullable = false)
	private Boolean vaccination;

	@Column(nullable = false)
	private Boolean sex;

	@Column
	private Double weight;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	private Customer owner;

	@OneToOne(mappedBy = "info", cascade = CascadeType.ALL)
	private Animal animal;

	@Column
	@Temporal(TemporalType.DATE)
	private Date sold;

	public AnimalInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getVaccination() {
		return vaccination;
	}

	public void setVaccination(Boolean vaccination) {
		this.vaccination = vaccination;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Date getSold() {
		return sold;
	}

	public void setSold(Date sold) {
		this.sold = sold;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

}
