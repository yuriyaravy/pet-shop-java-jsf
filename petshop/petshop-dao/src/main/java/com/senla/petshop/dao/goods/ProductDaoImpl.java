package com.senla.petshop.dao.goods;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.senla.petshop.api.dao.goods.ProductDao;
import com.senla.petshop.dao.AbstractDaoImpl;
import com.senla.petshop.model.goods.Product;
import com.senla.petshop.model.goods.ProductDetail;

@Repository
public class ProductDaoImpl extends AbstractDaoImpl<Product> implements ProductDao {

	public ProductDaoImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> productsWithDetails() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> root = query.from(Product.class);
		Fetch<Product, ProductDetail> productWithDetail = root.fetch("productDetail");
		return getSession().createQuery(query).getResultList();

	}

	@Override
	public List<Product> sortByName() {
		return getAll("name");
	}

}
