package com.hms.userservice.exception;

public class UsersCollectionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UsersCollectionException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "User with "+id+" not found!";
	}
	
	//exception for the same email
	public static String UserAlreadyExists() {
		return "User with given email already exists";
	}
//	
	//exception for the same user name
	public static String UserNameAlreadyExists() {
		return "User with given username already exists";
	}
//
//	

	
}
