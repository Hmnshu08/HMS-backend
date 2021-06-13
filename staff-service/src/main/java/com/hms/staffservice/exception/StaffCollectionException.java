package com.hms.staffservice.exception;

public class StaffCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public StaffCollectionException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Staff with "+id+" not found!";
	}
	
	//exception for the same email
	public static String StaffAlreadyExists() {
		return "Staff with given email already exists";
	}
}
