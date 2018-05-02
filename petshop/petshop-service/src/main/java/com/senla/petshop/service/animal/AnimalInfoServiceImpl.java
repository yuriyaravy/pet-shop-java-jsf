package com.senla.petshop.service.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.animal.AnimalInfoDao;
import com.senla.petshop.api.service.animal.AnimalInfoService;
import com.senla.petshop.model.animal.AnimalInfo;

@Service("animalInfoService")
public class AnimalInfoServiceImpl implements AnimalInfoService {

	@Autowired
	private AnimalInfoDao animalInfoDao;

	@Transactional
	@Override
	public List<AnimalInfo> getAll() {
		return animalInfoDao.getAll();
	}

	@Transactional
	@Override
	public void createAnimalInfo(AnimalInfo animalInfo) {
		animalInfoDao.create(animalInfo);
	}

}
