package com.lee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.lee.model.User;
import com.lee.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(id,password,name,age,sex,email) values (?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5, user.getSex());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setInt(7, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) { // 대부분 그대로 사용해도 됌
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from users where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) { 
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?" +
							"where userid=?");
			// Parameters start with 1
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5, user.getSex());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setInt(7, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from users where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
