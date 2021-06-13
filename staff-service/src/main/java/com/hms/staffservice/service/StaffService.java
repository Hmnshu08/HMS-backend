package com.hms.staffservice.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.hms.staffservice.exception.StaffCollectionException;
import com.hms.staffservice.models.Staff;



public interface StaffService {
	public void createStaff(Staff staff) throws ConstraintViolationException, StaffCollectionException;
	
	public List<Staff> getAllStaff();//get all the document method
	
	public Staff getSingleStaff(String id) throws StaffCollectionException; //get a single document through this method
	
	public void updateStaff(String id, Staff staff) throws StaffCollectionException; //update a document
	
	public void deleteStaffById(String id) throws StaffCollectionException;//delete a document from guest
}
