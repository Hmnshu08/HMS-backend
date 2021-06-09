package com.hms.guestservice.exception;

public class GuestCollectionException extends Exception {

	private static final long serialVersionUID = 1L;

	public GuestCollectionException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Guest with "+id+" not found!";
	}
	
	//exception for the same email
	public static String GuestAlreadyExists() {
		return "Guest with given email already exists";
	}
	
	//exception for the same contact number
	public static String ContactAlreadyExists() {
		return "Guest with given contact number already exists";
	}

	
	//exception for the same government ID number
	public static String GovIdAlreadyExists() {
		return "Guest with given govId number already exists";
	}
	
}
