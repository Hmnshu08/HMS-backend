package com.hms.userservice.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hms.userservice.exception.UsersCollectionException;
import com.hms.userservice.models.Users;
import com.hms.userservice.repository.UsersRepository;
import com.hms.userservice.service.UsersService;



@RestController
public class UsersController {

	
	@Autowired
	private UsersRepository usersRepo;
	
	@Autowired
	private UsersService usersService;
	
	
	//getting all the documents
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(){
		List<Users> users = usersService.getAllUsers();
		return new ResponseEntity<>(users,users.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
		
	}
	
	
	//adding a new document
	@PostMapping("/users")
	public ResponseEntity<?> createUsers(@RequestBody Users users){
		try {
			usersService.createUsers(users);
			return new ResponseEntity<Users>(users,HttpStatus.OK);
		}
		catch(ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		}
		catch(UsersCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	//getting the document by id
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getSingleUsers(@PathVariable("id") String id){
		
		try {
			return new ResponseEntity<>(usersService.getSingleUsers(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		

	}
	
	
	
	//update mapping
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUsers(@PathVariable("id") String id,@RequestBody Users users){
		
		try {
			usersService.updateUsers(id, users);
			return new ResponseEntity<>("Updated user with id" +id ,HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		} catch(UsersCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id){
		try {

			usersService.deleteUsersById(id);
			return new ResponseEntity<>("Successfully deleted with id" +id, HttpStatus.OK);
		}catch (UsersCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
