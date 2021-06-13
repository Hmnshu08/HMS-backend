package com.hms.reservationservice.exception;

public class ReservationCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ReservationCollectionException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Reservation with "+id+" not found!";
	}
	
	//exception for the same email
		public static String ReservationAlreadyExists() {
			return "Reservation with given GuestCode already exists";
		}
}
