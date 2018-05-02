package com.senla.petshop.api.dao.person;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.person.Address;

public interface AddressDao extends GenericDao<Address> {

	List<Address> sortByApartment();

	List<Address> sortByStreet();

	List<Address> sortByCity();

}
