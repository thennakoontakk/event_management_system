package com.customer;

public class events {
	
	private int eventid;
	private String eventtype;
	private String venue;
	private String date;
	
	private String name;
	private String email;
	private String contact;
	private String additional;
	private String price;
	
	public events(int eventid, String eventtype, String venue, String date, String name, String email,
			String contact, String additional, String price) {
		super();
		this.eventid = eventid;
		this.eventtype = eventtype;
		this.date = date;
		this.venue = venue;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.additional = additional;
		this.price = price;
	}

	public int getEventid() {
		return eventid;
	}

	public String getEventtype() {
		return eventtype;
	}

	

	public String getVenue() {
		return venue;
	}
	public String getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getContact() {
		return contact;
	}

	public String getAdditional() {
		return additional;
	}

	public String getPrice() {
		return price;
	}
	
	
	

}
