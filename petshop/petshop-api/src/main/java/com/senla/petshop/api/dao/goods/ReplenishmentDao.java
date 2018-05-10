package com.senla.petshop.api.dao.goods;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.goods.Replenishment;

public interface ReplenishmentDao extends GenericDao<Replenishment> {

	List<Replenishment> getReplenishmentWithStaff();

}
