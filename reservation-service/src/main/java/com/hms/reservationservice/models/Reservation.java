package com.hms.reservationservice.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@ApiModel(description="Reservation Model" )
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="reservations")
public class Reservation {
	@Id	
	@ApiModelProperty(notes="ID of the reservation", name="id", required = true, value="60c09475jhbf4a51fe8a96e6f")
	private String id;
	
	@ApiModelProperty(notes="ID of the guestCode", name="guestCode", required = true, value="1206")
	@NotNull(message="Guest Code cannot be null")
	private int guestCode;
	
	@ApiModelProperty(notes="checkin date of guest", name="checkIn", value="2021-06-20")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date checkIn;
	
	@ApiModelProperty(notes="checkout date of guest", name="checkOut", value="2021-06-30")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date checkOut;
	
	@ApiModelProperty(notes="Room number for the guest", name="roomNumber", value="103")
	@NotNull(message="Room number cannot be null")
	private int roomNumber;
	
	@ApiModelProperty(notes="Number of nights the guest", name="numberOfNights", value="9")
	private int numberOfNights;
	
	@ApiModelProperty(notes="Number adults among guest", name="adults", value="2")
	private int adults;
	
	@ApiModelProperty(notes="Number childres among guest", name="childrens", value="1")
	private int childrens;
	
	@ApiModelProperty(notes="Number adults among guest", name="reservationBy", value="Shilpa")
	private String reservationBy;
	
	
	List<Guest> guestDetails = new ArrayList<>();
	
	public Reservation(String id, @NotNull(message = "Guest Code cannot be null") int guestCode, Date checkIn,
			Date checkOut, @NotNull(message = "Room number cannot be null") int roomNumber, int numberOfNights,
			int adults, int childrens, String reservationBy, List<Guest> guestDetails) {
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
		this.guestDetails = guestDetails;
	}


	public List<Guest> getGuestDetails() {
		return guestDetails;
	}


	public void setGuestDetails(List<Guest> guestDetails) {
		this.guestDetails = guestDetails;
	}

	
	
	

	public Reservation() {
		super();
	}
	
	
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
