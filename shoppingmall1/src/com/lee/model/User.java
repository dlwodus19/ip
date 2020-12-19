package com.lee.model;

import java.util.Date;
import java.io.Serializable;

public class User implements Serializable {

	private int userid;
	private String id;
	private String password;
	private String name;
	private int age;
	private String sex;
	private String email;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid 
				+ ", id=" + id 
				+ ", Password=" + password
				+ ", Name=" + name
				+ ", age=" + age 
				+ ", sex=" + sex 
				+ ", email=" + email + "]";
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
