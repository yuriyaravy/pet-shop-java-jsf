package com.senla.petshop.api.dao.goods;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.goods.Product;

public interface ProductDao extends GenericDao<Product> {

	List<Product> sortByName();

}
