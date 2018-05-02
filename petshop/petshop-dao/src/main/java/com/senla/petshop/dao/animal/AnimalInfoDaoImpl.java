package com.senla.petshop.dao.animal;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.animal.AnimalInfoDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.animal.AnimalInfo;
import com.senla.petshop.model.person.Customer;

@Repository
public class AnimalInfoDaoImpl extends AbstractDaoImpl<AnimalInfo> implements AnimalInfoDao {

	private static final String NAME = "name";
	private static final String AGE = "age";
	private static final String VACCINATION = "vaccination";
	private static final String WEIGHT = "weight";

	public AnimalInfoDaoImpl() {
		super(AnimalInfo.class);
	}

	@Override
	public List<Object[]> getAnimalInfoAndOwner() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<Customer> rootCustomer = query.from(Customer.class);
		Root<AnimalInfo> rootAnimalInfo = query.from(AnimalInfo.class);
		query.multiselect(rootCustomer, rootAnimalInfo)
				.where(builder.equal(rootAnimalInfo.get("owner"), rootCustomer.get("id")));
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<AnimalInfo> getAnimalInfoSold() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<AnimalInfo> query = builder.createQuery(AnimalInfo.class);
		Root<AnimalInfo> root = query.from(AnimalInfo.class);
		query.select(root).where(builder.isNotNull(root.get("sold")));
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<AnimalInfo> sortByWeight() {
		return getAll(WEIGHT);
	}

	@Override
	public List<AnimalInfo> sortByVaccionation() {
		return getAll(VACCINATION);
	}

	@Override
	public List<AnimalInfo> sortByName() {
		return getAll(NAME);
	}

	@Override
	public List<AnimalInfo> sortByAge() {
		return getAll(AGE);
	}

}
