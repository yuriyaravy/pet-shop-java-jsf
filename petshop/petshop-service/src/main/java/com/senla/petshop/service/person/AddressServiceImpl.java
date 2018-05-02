package com.senla.petshop.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.person.AddressDao;
import com.senla.petshop.api.service.person.AddressService;
import com.senla.petshop.model.person.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Override
	public void persistAddress(Address address) {
		addressDao.create(address);
	}

}
