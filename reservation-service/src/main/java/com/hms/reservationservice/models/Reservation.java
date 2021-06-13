package com.hms.reservationservice.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="reservations")
public class Reservation {
	@Id	
	private String id;
	@NotNull(message="Guest Code cannot be null")
	private int guestCode;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date checkIn;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date checkOut;
	
	@NotNull(message="Room number cannot be null")
	private int roomNumber;
	private int numberOfNights;
	private int adults;
	private int childrens;
	private String reservationBy;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGuestCode() {
		return guestCode;
	}
	public void setGuestCode(int guestCode) {
		this.guestCode = guestCode;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getNumberOfNights() {
		return numberOfNights;
	}
	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
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
	public String getReservationBy() {
		return reservationBy;
	}
	public void setReservationBy(String reservationBy) {
		this.reservationBy = reservationBy;
	}
	
	
	public Reservation(String id, @NotNull(message = "Guest Code cannot be null") int guestCode, Date checkIn,
			Date checkOut, @NotNull(message = "Room number cannot be null") int roomNumber, int numberOfNights,
			int adults, int childrens, String reservationBy) {
		super();
		this.id = id;
		this.guestCode = guestCode;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
		this.numberOfNights = numberOfNights;
		this.adults = adults;
		this.childrens = childrens;
		this.reservationBy = reservationBy;
	}
	
	
	
	
	
	
}
