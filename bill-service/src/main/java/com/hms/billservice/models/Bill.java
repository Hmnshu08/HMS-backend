package com.hms.billservice.models;

import java.util.Date;

public class Bill {

	private int billNo;
	private String name;
	private String checkIn;
	private String checkOut;
	private int numberOfNights;
	private String roomType;
	private int adults;
	private int childrens;
	private double tax;
	private double totalAmt;
	private long cardNumber;
	private String cardType;
	
	
	public Bill(int billNo, String name, String checkIn, String checkOut, int numberOfNights, String roomType,
			int adults, int childrens, double tax, double totalAmt, long cardNumber, String cardType) {
		super();
		this.billNo = billNo;
		this.name = name;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfNights = numberOfNights;
		this.roomType = roomType;
		this.adults = adults;
		this.childrens = childrens;
		this.tax = tax;
		this.totalAmt = totalAmt;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}
	
	
	
	
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getNumberOfNights() {
		return numberOfNights;
	}
	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildrens() {
		return childrens;
	}
	public void setChildrens(int childrens) {
		this.childrens = childrens;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
	

	
	
	
}
