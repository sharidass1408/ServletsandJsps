package com.nbna.model;

public class User {

	private String name;	
	private String userid;
	private String password;
	private String email;
	private Address address; 	
 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	 
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
