package com.hms.guestservice.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.hms.guestservice.exception.GuestCollectionException;
import com.hms.guestservice.models.Guest;

public interface GuestService {
	public void createGuest(Guest guest) throws ConstraintViolationException, GuestCollectionException;
	
	public List<Guest> getAllGuest();//get all the document method
	
	public Guest getSingleGuest(String id) throws GuestCollectionException; //get a single document through this method
	
	public void updateGuest(String id, Guest guest) throws GuestCollectionException; //update a document
	
	public void deleteGuestById(String id) throws GuestCollectionException;//delete a document from guest
	
	
}
