
package com.lotus.jdbcexample.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Person {
	private long id;
	private String name;
	private Date birthday;
	private BigDecimal balance;
	private long petId;
	
	public Person(String name, Date birthday, BigDecimal balance, long petId) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.balance = balance;
		this.petId = petId;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthday=" + birthday + ", balance=" + balance + ", petId="
				+ petId + "]";
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	
}
