package com.senla.petshop.dao.animal;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.animal.AnimalDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.animal.Animal;
import com.senla.petshop.model.animal.AnimalInfo;
import com.senla.petshop.model.animal.AnimalType;

@Repository
public class AnimalDaoImpl extends AbstractDaoImpl<Animal> implements AnimalDao {

	public AnimalDaoImpl() {
		super(Animal.class);
	}

	public List<Animal> getAnimalAndInfoAndTypeNullCustomer() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
		Root<Animal> root = query.from(Animal.class);
		Fetch<Animal, AnimalInfo> animalFetch = root.fetch("info");
		Fetch<Animal, AnimalType> animalFetchType = root.fetch("type");
		query.select(root).where(builder.equal(root.get("owner"), null));
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<Animal> getAnimalAndInfoAndType() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
		Root<Animal> root = query.from(Animal.class);
		Fetch<Animal, AnimalInfo> animalFetch = root.fetch("info");
		Fetch<Animal, AnimalType> animalFetchType = root.fetch("type");
		return getSession().createQuery(query).getResultList();
	}

}
