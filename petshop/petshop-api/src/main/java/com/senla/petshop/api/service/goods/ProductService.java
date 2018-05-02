package com.senla.petshop.api.service.goods;

import java.util.List;

import com.senla.petshop.model.goods.Product;

public interface ProductService {

	List<Product> productList();

	void persistProduct(Product product);

}
