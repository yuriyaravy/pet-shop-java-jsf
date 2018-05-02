package com.senla.petshop.api.dao;

import java.util.List;

public interface GenericDao<T> {

	void create(T object);

	void delete(T object);

	void update(T object);

	T getById(Integer id);

	List<T> getAll(String... sort);

}
