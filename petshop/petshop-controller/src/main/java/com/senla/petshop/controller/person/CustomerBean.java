package com.senla.petshop.controller.person;

import com.senla.petshop.api.service.animal.AnimalService;
import com.senla.petshop.api.service.goods.OrderService;
import com.senla.petshop.api.service.goods.ProductService;
import com.senla.petshop.api.service.person.CustomerService;
import com.senla.petshop.model.animal.Animal;
import com.senla.petshop.model.enums.OrderStatus;
import com.senla.petshop.model.goods.Order;
import com.senla.petshop.model.goods.Product;
import com.senla.petshop.model.person.Customer;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "customerBean")
@RequestScoped
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{customerService}")
	private CustomerService customerService;

	@ManagedProperty(value = "#{orderService}")
	private OrderService orderService;

	@ManagedProperty(value = "#{animalService}")
	private AnimalService animalService;

	@ManagedProperty(value = "#{productService}")
	private ProductService productService;

	private Customer customer;
	private Order order;
	private Animal animal;
	private Product product;
	private List<Product> products;
	private List<Animal> animals;
	private List<Order> orders;
	private List<Customer> customers;

	@PostConstruct
	public void init() {
		orders = orderService.orderWithCustomer();
		customers = customerService.customerWithOrder();
//		products = productService.productsWithDetails();
		// animals = animalService.
	}

	public void addAnimalToCustomer(Animal animal) {
		animalService.getAnimalById(animal.getId());
		List<Animal> animals = customer.getPets();
		animals.add(animalService.getAnimalById(animal.getId()));
		this.customer.setPets(animals);
		customerService.update(this.customer);
	}

	public void addProductToCustomerOrder(Product product) {
		Order order = new Order();
		order.setStatus(OrderStatus.PROCESSING);
		order.setProduct(productService.getProductById(product.getId()));
		this.customer.setOrder((List<Order>) order);
		customerService.update(this.customer);
	}

	public AnimalService getAnimalService() {
		return animalService;
	}

	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

}
