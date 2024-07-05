package com.customer;

public class customer {

	private int id;
	private String name;
	private String address;
	private String email;
	private String phone;
	private String username;
	private String password;
	
	
	public customer(int id, String name,String address, String email, String phone, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
	
	
	
}
