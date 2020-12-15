package net.lee.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.lee.registration.model.Human;

public class HumanDao {
	
	public int registerHuman(Human human) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee" +
				"  (id, first_name, last_name, username, password, address, contact) VALUES " +
				" (?, ?, ?, ?, ?, ?, ?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "19a46b");
			
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, human.getFirstName());
			preparedStatement.setString(3, human.getLastName());
			preparedStatement.setString(4, human.getUsername());
			preparedStatement.setString(5, human.getPassword());
			preparedStatement.setString(6, human.getAddress());
			preparedStatement.setString(7, human.getContact());
			
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
}