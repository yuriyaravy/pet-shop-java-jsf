package com.senla.petshop.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.goods.ProductDao;
import com.senla.petshop.api.service.goods.ProductService;
import com.senla.petshop.model.goods.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> productsWithDetails() {
		return productDao.productsWithDetails();
	}

	@Override
	public Product getProductById(Integer id) {
		return productDao.getById(id);
	}

	@Override
	public void persistProduct(Product product) {
		productDao.create(product);
	}

	@Override
	public List<Product> productList() {
		return productDao.getAll();
	}
}
