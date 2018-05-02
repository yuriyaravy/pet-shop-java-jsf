package com.senla.petshop.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.petshop.api.dao.goods.ProductDetailDao;
import com.senla.petshop.api.service.goods.ProductDetailService;
import com.senla.petshop.model.goods.ProductDetail;

@Service("productDetailService")
public class ProductDetailServiceImpl implements ProductDetailService {

	@Autowired
	private ProductDetailDao productDetailDao;
	
	@Override
	public void persistProductDetail(ProductDetail productDetail) {
		productDetailDao.create(productDetail);
	}

}
