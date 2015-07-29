package com.lotus.jdbcexample;

import java.math.BigDecimal;
import java.util.Date;

import com.lotus.jdbcexample.dao.AnimalDAO;
import com.lotus.jdbcexample.dao.AnimalOJDBDAO;
import com.lotus.jdbcexample.dao.PersonDAO;
import com.lotus.jdbcexample.dao.PersonOJDBCDAO;
import com.lotus.jdbcexample.domain.Animal;
import com.lotus.jdbcexample.domain.Person;

public class Main {
	public static void main(String args[]) {
		AnimalDAO animalDAO = AnimalOJDBDAO.getInstance();
//		Animal pluto = animalDAO.getByName("pluto");
//		animalDAO.delete(pluto);
		Animal hellokitty = animalDAO.getByName("hellokitty");
//		if(pluto != null){
//			pluto.setAlive(false);
//			pluto.setSpecies("dead dog");
//			animalDAO.update(pluto);
//		}
//		Animal dog = new Animal("pluto2", "dog", 10, true);
//		dog.persist();
//		for(Animal animal: animalDAO.list()){
//			System.out.println(animal);
//			
//		}
//		System.out.println("Done.");
//		Date birthday = new Date();
		PersonDAO personDAO = PersonOJDBCDAO.getInstance();
//		Person kerby = new Person("Kerby", birthday, new BigDecimal("1000"), hellokitty.getId());
//		personDAO.create(kerby);
		for(Person person: personDAO.list()){
			System.out.println(person);
			
		}
	}
}
