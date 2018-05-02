package com.senla.petshop.dao.person;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.person.AddressDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.person.Address;

@Repository
public class AddressDaoImpl extends AbstractDaoImpl<Address> implements AddressDao {

	private static final String CITY = "city";
	private static final String STREET = "street";
	private static final String APARTMENT = "apartment";

	public AddressDaoImpl() {
		super(Address.class);
	}

	@Override
	public List<Address> sortByApartment() {
		return getAll(APARTMENT);
	}

	@Override
	public List<Address> sortByStreet() {
		return getAll(STREET);
	}

	@Override
	public List<Address> sortByCity() {
		return getAll(CITY);
	}

}
