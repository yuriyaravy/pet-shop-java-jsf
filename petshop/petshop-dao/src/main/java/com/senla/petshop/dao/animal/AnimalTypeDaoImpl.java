package com.senla.petshop.dao.animal;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.animal.AnimalTypeDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.animal.AnimalType;

@Repository
public class AnimalTypeDaoImpl extends AbstractDaoImpl<AnimalType> implements AnimalTypeDao {

	private static final String VARIETY = "variaty";
	private static final String QUANTITY = "quantity";

	public AnimalTypeDaoImpl() {
		super(AnimalType.class);
	}

	@Override
	public List<AnimalType> getByVariaty(String variaty) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<AnimalType> query = builder.createQuery(AnimalType.class);
		Root<AnimalType> root = query.from(AnimalType.class);
		query.select(root).where(builder.equal(root.get(VARIETY), variaty));
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public List<AnimalType> sortByQuantity() {
		return getAll(QUANTITY);
	}

	@Override
	public List<AnimalType> sortByVariaty() {
		return getAll(VARIETY);
	}

}
