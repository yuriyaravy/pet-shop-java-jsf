package com.senla.petshop.dao.person;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.person.AdminDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.person.Admin;

@Repository
public class AdminDaoImpl extends AbstractDaoImpl<Admin> implements AdminDao {

	public AdminDaoImpl() {
		super(Admin.class);
	}

}
