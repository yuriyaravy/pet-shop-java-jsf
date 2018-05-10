package com.senla.petshop.dao.goods;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.goods.ReplenishmentDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.goods.Product;
import com.senla.petshop.model.goods.Replenishment;
import com.senla.petshop.model.person.Admin;

@Repository
public class ReplenishmentDaoImpl extends AbstractDaoImpl<Replenishment> implements ReplenishmentDao {

	public ReplenishmentDaoImpl() {
		super(Replenishment.class);
	}

	@Override
	public List<Replenishment> getReplenishmentWithStaff() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Replenishment> query = builder.createQuery(Replenishment.class);
		Root<Replenishment> root = query.from(Replenishment.class);
		Fetch<Replenishment, Admin> animalFetch = root.fetch("admin");
		Fetch<Replenishment, List<Product>> ReplenishmentProducts = root.fetch("products");
		return getSession().createQuery(query).getResultList();
	}

}
