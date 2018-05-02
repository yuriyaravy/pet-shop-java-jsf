package com.senla.petshop.model.person;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senla.petshop.model.Base;

@Entity
@Table(name = "aunthenticator")
public class Authenticator extends Base {

	@Column(unique = true, nullable = false)
	private String login;

	@Column(nullable = false)
	private String password;

	@OneToOne(mappedBy = "aunthenticator", cascade = CascadeType.ALL)
	private Person person;

	public Authenticator() {
	}

	public Authenticator(Integer id, String login, String password) {
		super(id);
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
