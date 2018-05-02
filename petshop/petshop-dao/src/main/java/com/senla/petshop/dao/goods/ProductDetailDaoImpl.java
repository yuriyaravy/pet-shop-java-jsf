package com.senla.petshop.dao.goods;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.goods.ProductDetailDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.goods.ProductDetail;

@Repository
public class ProductDetailDaoImpl extends AbstractDaoImpl<ProductDetail> implements ProductDetailDao {

	private static final String NAME = "name";

	public ProductDetailDaoImpl() {
		super(ProductDetail.class);
	}

	@Override
	public List<ProductDetail> sortByName() {
		return getAll(NAME);
	}

}
