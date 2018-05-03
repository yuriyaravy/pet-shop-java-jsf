package com.senla.petshop.controller.goods;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.senla.petshop.api.service.goods.ProductDetailService;
import com.senla.petshop.api.service.goods.ProductService;
import com.senla.petshop.api.service.person.AddressService;
import com.senla.petshop.model.goods.Product;
import com.senla.petshop.model.goods.ProductDetail;
import com.senla.petshop.model.person.Address;

@ManagedBean(name = "productBean")
@RequestScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{productService}")
	private ProductService productService;

	@ManagedProperty(value = "#{productDetailService}")
	private ProductDetailService detailService;

	@ManagedProperty(value = "#{addressService}")
	private AddressService addressService;

	private Product product;
	private ProductDetail productDetail;
	private Address adress;
	private List<Product> products;

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public ProductService getProductService() {
		if (productDetail == null) {
			productDetail = new ProductDetail();
		}
		return productService;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setDetailService(ProductDetailService detailService) {
		this.detailService = detailService;
	}

	public Product getProduct() {
		if (product == null) {
			product = new Product();
		}
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDetail getProductDetail() {
		if (productDetail == null) {
			productDetail = new ProductDetail();
		}
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void persistProduct() {
		Product product = new Product();
		this.productDetail.setAddress(this.adress);
		product.setProductDetail(this.productDetail);
		productService.persistProduct(product);
	}

}
