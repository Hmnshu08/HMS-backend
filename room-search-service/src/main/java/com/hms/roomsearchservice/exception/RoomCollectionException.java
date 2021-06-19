package com.hms.roomsearchservice.exception;
public class RoomCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public RoomCollectionException(String message) {
		super(message);
	}
	
	
	public static String NotFoundException(String id) {
		return "Room not found!";
	}
	
	
	//exception for the same room number
//	public static String RoomAlreadyExists() {
//		return "Room with given Number already exists";
//	}
//	
//	public static String RoomCantBeChanged() {
//		return "Room Number Cannot be Changed";
//	}
	
}