package com.hms.userservice.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.hms.userservice.exception.UsersCollectionException;
import com.hms.userservice.models.Users;



public interface UsersService {

public void createUsers(Users users) throws ConstraintViolationException, UsersCollectionException;
	
	public List<Users> getAllUsers();//get all the document method
	
	public Users getSingleUsers(String id) throws UsersCollectionException; //get a single document through this method
	
	public void updateUsers(String id, Users users) throws UsersCollectionException; //update a document
	
	public void deleteUsersById(String id) throws UsersCollectionException;//delete a document from users
}
