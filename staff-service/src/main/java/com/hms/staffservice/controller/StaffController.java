package com.hms.staffservice.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hms.staffservice.exception.StaffCollectionException;
import com.hms.staffservice.models.Staff;
import com.hms.staffservice.repository.StaffRepository;
import com.hms.staffservice.service.StaffService;



@RestController
//@RequestMapping("/api")
public class StaffController {

	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private StaffService staffService;
	
	//getting all the documents
	@GetMapping("/staff")
	public ResponseEntity<?> getAllStaff(){
		
		List<Staff> staff = staffService.getAllStaff();
		return new ResponseEntity<>(staff,staff.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
		
		
	}
	
	//adding a new document
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
		@GetMapping("/staff/{id}")
		public ResponseEntity<?> getSingleStaff(@PathVariable("id") String id){
			
			try {
				return new ResponseEntity<>(staffService.getSingleStaff(id),HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
	
		
		//update mapping
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
