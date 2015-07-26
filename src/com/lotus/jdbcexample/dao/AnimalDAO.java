package com.lotus.jdbcexample.dao;

import java.util.List;

import com.lotus.jdbcexample.domain.Animal;
public interface AnimalDAO {
	void create(Animal a);
	void update(Animal a);
	void delete(Animal a);
	List<Animal> list();
	Animal getByName(String name);
}
