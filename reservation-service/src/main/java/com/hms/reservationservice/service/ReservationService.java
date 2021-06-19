package com.hms.reservationservice.service;

import java.util.List;

import javax.validation.ConstraintViolationException;


import com.hms.reservationservice.exception.ReservationCollectionException;
import com.hms.reservationservice.models.Guest;
import com.hms.reservationservice.models.Reservation;

public interface ReservationService {

	
public void createReservation(Reservation reservation) throws ConstraintViolationException, ReservationCollectionException;
	
	public List<Reservation> getAllReservation();//get all the document method
	
	
//	public Guest getGuest(int guestCode);
	
	
	
	public Reservation getSingleReservation(String id) throws ReservationCollectionException; //get a single document through this method
	
	public void updateReservation(String id, Reservation reservation) throws ReservationCollectionException; //update a document
	
	public void deleteReservationById(String id) throws ReservationCollectionException;//delete a document from reservation

}
