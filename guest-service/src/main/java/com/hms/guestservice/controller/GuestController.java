package com.hms.guestservice.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.guestservice.exception.GuestCollectionException;
import com.hms.guestservice.models.Guest;
import com.hms.guestservice.repository.GuestRepository;
import com.hms.guestservice.service.GuestService;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



//@RequestMapping("/api")
@ApiOperation(value = "/guest", tags = "Guest Controller")
@RestController
public class GuestController {
	
	@Autowired
	private GuestRepository guestRepo;
	
	@Autowired
	private GuestService guestService;
	

	@ApiOperation(value = "Fetch all Guest", response = Guest.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "SUCCESS", response = Guest.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED!", response = Guest.class),
			@ApiResponse(code = 403, message = "FORBIDDEN", response = Guest.class),
			@ApiResponse(code = 404, message = "NOT FOUND")
	})
	@CrossOrigin(origins = "http://localhost:3000")
	//getting all the documents
	@GetMapping("/guest")
	public ResponseEntity<?> getAllGuest(){
		List<Guest> guest = guestService.getAllGuest();
		return new ResponseEntity<>(guest,guest.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
		
	}
	
	//adding a new document
	@ApiOperation(value = "Post a new guest", response = Guest.class)
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/guest")
	public ResponseEntity<?> createGuest(@RequestBody Guest guest){
		try {

//			guestRepo.save(guest);
//			now we need service to call the method
			guestService.createGuest(guest);
			return new ResponseEntity<Guest>(guest,HttpStatus.OK);
		}
		catch(ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		}catch (GuestCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	//getting the document by id
	@ApiOperation(value = "Get a guest by Id", response = Guest.class)
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/guest/{id}")
	public ResponseEntity<?> getSingleGuest(@PathVariable("id") String id){
		
		try {
			return new ResponseEntity<>(guestService.getSingleGuest(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
		
		
//		Optional<Guest> guestOptional = guestRepo.findById(id);
//		if(guestOptional.isPresent()) {
//			return new ResponseEntity<>(guestOptional.get(),HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>("Guest not found with id "+id,HttpStatus.NOT_FOUND);
//		}
	}
	
	
	
	
	
	
	//update mapping
	@ApiResponse(code = 200, message = "SUCCESS", response = Guest.class, responseContainer = "List")
	@ApiOperation(value = "Update a Guest by Id", response = Guest.class)
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/guest/{id}")
	public ResponseEntity<?> updateGuest(@PathVariable("id") String id,@RequestBody Guest guest){
		
		try {
			guestService.updateGuest(id, guest);
			return new ResponseEntity<>("Updated guest with id" +id ,HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		} catch(GuestCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
// all the condition is refactored in guest service	implementation	
//		Optional<Guest> guestOptional = guestRepo.findById(id);
//		if(guestOptional.isPresent()) {
//			Guest guestToSave = guestOptional.get();
//			guestToSave.setCity(guest.getAddresss() != null ? guest.getAddresss():guestToSave.getName());
//			guestToSave.setGender(guest.getGender() != null ? guest.getGender():guestToSave.getGender());
//			guestToSave.setEmail(guest.getEmail() != null ? guest.getEmail():guestToSave.getEmail());
//			guestToSave.setCity(guest.getCity() != null ? guest.getCity():guestToSave.getCity());
//			guestToSave.setState(guest.getState() != null ? guest.getState():guestToSave.getState());
//			guestToSave.setCountry(guest.getCountry() != null ? guest.getCountry():guestToSave.getCountry());
//			guestToSave.setPostalCode(guest.getPostalCode() != null ? guest.getPostalCode():guestToSave.getPostalCode());
//			guestToSave.setIdType(guest.getIdType() != null ? guest.getIdType():guestToSave.getIdType());
//			guestToSave.setGovId(guest.getGovId() != null ? guest.getGovId():guestToSave.getGovId());
//			guestToSave.setAddresss(guest.getAddresss() != null ? guest.getAddresss():guestToSave.getAddresss());
//			guestToSave.setContact(guest.getContact() != null ? guest.getContact():guestToSave.getContact());
//			guestToSave.setPhone(guest.getPhone() != null ? guest.getPhone():guestToSave.getPhone());
////			guestToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
//			guestRepo.save(guestToSave);
//			
//			return new ResponseEntity<>(guestToSave,HttpStatus.OK);
//			
//		}
//		else
//		{
//			return new ResponseEntity<>("Guest not found with id "+id,HttpStatus.NOT_FOUND);
//		}
	}
	
	@ApiOperation(value = "Delete a guest by Id", response = Guest.class)	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/guest/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id){
		try {
//			guestRepo.deleteById(id);
			guestService.deleteGuestById(id);
			return new ResponseEntity<>("Successfully deleted with id" +id, HttpStatus.OK);
		}catch (GuestCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
}
