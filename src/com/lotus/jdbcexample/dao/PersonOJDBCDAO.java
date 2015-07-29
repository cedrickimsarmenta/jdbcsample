package com.lotus.jdbcexample.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lotus.jdbcexample.domain.Person;

public class PersonOJDBCDAO implements PersonDAO {
	private static PersonOJDBCDAO instance = null;
	
	public static PersonOJDBCDAO getInstance() {
		if(instance == null) {
			instance = new PersonOJDBCDAO();
		}
		return instance;
	}
	
	private PersonOJDBCDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Unable to establish database connection");
		}
	}
	
	private static Connection getConnection(){
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ernest",
					"password");
			connection.setAutoCommit(false);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException("Cant connect to Database");
		}
		
	}
	
	
	public void create(Person p) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("INSERT INTO persons (id, name, birthday, balance, pet_ID) VALUES (persons_seq.nextVal, ?, ?, ?, ?)");
			statement.setString(1, p.getName());
			Date sqlBirthday = new Date(p.getBirthday().getTime());
			statement.setDate(2, sqlBirthday);
			statement.setBigDecimal(3, p.getBalance());
			statement.setLong(4, p.getPetId());
			
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				if(connection != null){
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				
			}
			e.printStackTrace();
			throw new RuntimeException("DAtabase Error.");
		}finally{
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Person p) {
		// TODO Auto-generated method stub
		
	}

	public List<Person> list() {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<Person>();
		Connection connection = null;
		Statement statement = null;
		
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
			String sql = ("SELECT * FROM PERSONS");
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				persons.add(extractPersonFromResult(rs));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Database error.");
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		return persons;
	}
	private Person extractPersonFromResult(ResultSet rs) throws SQLException{
		long id = rs.getLong("id");
		String name = rs.getString("name");
		Date birthday = rs.getDate("birthday");
		BigDecimal balance = rs.getBigDecimal("balance");
		long petId = rs.getLong("pet_id");
		Person person = new Person(name, birthday, balance, petId);
		
		return person;
		
	}

	public Person getByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
