package com.senla.petshop.dao.goods;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.goods.ProductDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.goods.Product;

@Repository
public class ProductDaoImpl extends AbstractDaoImpl<Product> implements ProductDao {

	public static final String NAME = "name";

	public ProductDaoImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> sortByName() {
		return getAll(NAME);
	}

}
