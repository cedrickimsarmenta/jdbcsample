package com.lotus.jdbcexample.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Person {
	private long id;
	private String name;
	private Date birthday;
	private BigDecimal balance;
	private Animal pet;
}