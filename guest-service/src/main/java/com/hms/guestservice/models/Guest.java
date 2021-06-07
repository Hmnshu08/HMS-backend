package com.hms.guestservice.models;

public class Guest {
	private int GuestCode;
	private String name;
	private String gender;
	private String email;
	private String city;
	private String state;
	private	String country;
	private int postalCode;
	private String idType;
	private String govId;
	private String Address;
	private int contact;
	private int phone;
	
	public Guest(int guestCode, String name, String gender, String email, String city, String state, String country,
			int postalCode, String idType, String govId, String address, int contact, int phone) {
		super();
		this.GuestCode = guestCode;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.idType = idType;
		this.govId = govId;
		this.Address = address;
		this.contact = contact;
		this.phone = phone;
	}
	public int getGuestCode() {
		return GuestCode;
	}
	public void setGuestCode(int guestCode) {
		GuestCode = guestCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getGovId() {
		return govId;
	}
	public void setGovId(String govId) {
		this.govId = govId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	
	
	
}