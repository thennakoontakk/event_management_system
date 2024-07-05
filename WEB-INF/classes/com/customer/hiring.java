package com.customer;

public class hiring {
	
	private int hiringid;
	private String name;
	private String email;
	private String phone;
	private String dob;
	private String address;
	private String dancestyle;
	private String experience;
	
	public hiring(int hiringid, String name, String email, String phone, String dob, String address,
			String dancestyle, String experience) {
		super();
		this.hiringid = hiringid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.address = address;
		this.dancestyle = dancestyle;
		this.experience = experience;
	}

	public int getHiringid() {
		return hiringid;
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

	public String getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public String getDancestyle() {
		return dancestyle;
	}

	public String getExperience() {
		return experience;
	}
	
	
	
	
	
	

}
