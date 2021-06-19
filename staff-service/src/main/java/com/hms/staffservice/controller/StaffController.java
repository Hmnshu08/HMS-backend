package com.hms.staffservice.controller;

import java.util.List;

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


import com.hms.staffservice.exception.StaffCollectionException;
import com.hms.staffservice.models.Staff;
import com.hms.staffservice.repository.StaffRepository;
import com.hms.staffservice.service.StaffService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


//@RequestMapping("/api")
@ApiOperation(value = "/staff", tags = "Staff Controller")
@RestController
public class StaffController {

	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private StaffService staffService;
	
	//getting all the documents
	@ApiOperation(value = "Fetch all Staff", response = Staff.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "SUCCESS", response = Staff.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED!", response = Staff.class),
			@ApiResponse(code = 403, message = "FORBIDDEN", response = Staff.class),
			@ApiResponse(code = 404, message = "NOT FOUND")
	})
	@GetMapping("/staff")
	public ResponseEntity<?> getAllStaff(){
		
		List<Staff> staff = staffService.getAllStaff();
		return new ResponseEntity<>(staff,staff.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
		
		
	}
	
	//adding a new document
	@ApiOperation(value = "Post a new Staff", response = Staff.class)
	@CrossOrigin(origins = "http://localhost:3000")
		@PostMapping("/staff")
		public ResponseEntity<?> createStaff(@RequestBody Staff staff){
			try {

//				now we need service to call the method
				staffService.createStaff(staff);
				return new ResponseEntity<Staff>(staff,HttpStatus.OK);
			}
			catch(ConstraintViolationException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			}catch (StaffCollectionException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
			}
		}
		
		
		
		//getting the document by id
		@ApiOperation(value = "Get a Staff by Id", response = Staff.class)
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/staff/{id}")
		public ResponseEntity<?> getSingleStaff(@PathVariable("id") String id){
			
			try {
				return new ResponseEntity<>(staffService.getSingleStaff(id),HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
	
		
		//update mapping
		@ApiResponse(code = 200, message = "SUCCESS", response = Staff.class, responseContainer = "List")
		@ApiOperation(value = "Update a staff by Id", response = Staff.class)
		@CrossOrigin(origins = "http://localhost:3000")
		@PutMapping("/staff/{id}")
		public ResponseEntity<?> updateStaff(@PathVariable("id") String id,@RequestBody Staff staff){
			
			try {
				staffService.updateStaff(id, staff);
				return new ResponseEntity<>("Updated staff with id" +id ,HttpStatus.OK);
			} catch (ConstraintViolationException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			} catch(StaffCollectionException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
	
		
		@ApiOperation(value = "Delete a staff by Id", response = Staff.class)
		@DeleteMapping("/staff/{id}")
		public ResponseEntity<?> deleteById(@PathVariable("id") String id){
			try {

				staffService.deleteStaffById(id);
				return new ResponseEntity<>("Successfully deleted with id" +id, HttpStatus.OK);
			}catch (StaffCollectionException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
	
	
	
	
}
