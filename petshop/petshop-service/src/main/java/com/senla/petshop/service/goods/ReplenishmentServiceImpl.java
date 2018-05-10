package com.senla.petshop.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.goods.ReplenishmentDao;
import com.senla.petshop.api.service.goods.ReplenishmentService;
import com.senla.petshop.model.goods.Replenishment;

@Service("replenishmentService")
@Transactional
public class ReplenishmentServiceImpl implements ReplenishmentService {

	@Autowired
	private ReplenishmentDao replenishmentDao;

	@Override
	public List<Replenishment> getReplenishmentWithStaff() {
		return replenishmentDao.getReplenishmentWithStaff();
	}

}
