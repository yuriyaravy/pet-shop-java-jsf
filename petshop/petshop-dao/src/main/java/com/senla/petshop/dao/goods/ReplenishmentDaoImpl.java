package com.senla.petshop.dao.goods;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.goods.ReplenishmentDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.goods.Replenishment;

@Repository
public class ReplenishmentDaoImpl extends AbstractDaoImpl<Replenishment> implements ReplenishmentDao {

	public ReplenishmentDaoImpl() {
		super(Replenishment.class);
	}

}
