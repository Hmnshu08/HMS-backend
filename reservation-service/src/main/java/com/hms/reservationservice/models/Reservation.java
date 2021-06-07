package com.hms.reservationservice.models;

public class Reservation {

	private int guestCode;
	private String Name;
	private int roomNumber;
	private String checkIn;
	private String checkOut;
	private String roomType;
	private int numberOfNights;
	private int Adults;
	private int childrens;
	private String reservationBy;
	public int getGuestCode() {
		return guestCode;
	}
	public void setGuestCode(int guestCode) {
		this.guestCode = guestCode;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNumberOfNights() {
		return numberOfNights;
	}
	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}
	public int getAdults() {
		return Adults;
	}
	public void setAdults(int adults) {
		Adults = adults;
	}
	public int getChildrens() {
		return childrens;
	}
	public void setChildrens(int childrens) {
		this.childrens = childrens;
	}
	public String getReservationBy() {
		return reservationBy;
	}
	public void setReservationBy(String reservationBy) {
		this.reservationBy = reservationBy;
	}
	public Reservation(int guestCode, String name, int roomNumber, String checkIn, String checkOut, String roomType,
			int numberOfNights, int adults, int childrens, String reservationBy) {
		super();
		this.guestCode = guestCode;
		Name = name;
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomType = roomType;
		this.numberOfNights = numberOfNights;
		Adults = adults;
		this.childrens = childrens;
		this.reservationBy = reservationBy;
	}
	
	
	
}
