package com.customer;

public class contactus {
	
	private int contactid;
	private String name;
	private String email;
	private String phone;
	private String message;
	
	public contactus(int contactid, String name, String email, String phone, String message) {
		super();
		this.contactid = contactid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.message = message;
	}

	public int getContactid() {
		return contactid;
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

	public String getMessage() {
		return message;
	}
	
	
	
	
	
	

}
