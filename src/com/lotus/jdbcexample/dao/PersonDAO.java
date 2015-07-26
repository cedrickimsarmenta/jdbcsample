package com.lotus.jdbcexample.dao;

import java.util.List;

import com.lotus.jdbcexample.domain.Person;

public interface PersonDAO {
	void create(Person p);
	void update(Person p);
	void delete(Person p);
	List<Person> list();
	Person getByName();
}
