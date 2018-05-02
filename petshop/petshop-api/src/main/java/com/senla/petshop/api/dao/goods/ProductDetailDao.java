package com.senla.petshop.api.dao.goods;

import java.util.List;

import com.senla.petshop.api.dao.GenericDao;
import com.senla.petshop.model.goods.ProductDetail;

public interface ProductDetailDao extends GenericDao<ProductDetail> {

	List<ProductDetail> sortByName();

}
