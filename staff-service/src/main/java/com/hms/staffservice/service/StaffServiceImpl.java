package com.hms.staffservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hms.staffservice.exception.StaffCollectionException;
import com.hms.staffservice.models.Staff;
import com.hms.staffservice.repository.StaffRepository;


@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffRepository staffRepo;

	@Override
	public void createStaff(Staff staff) throws ConstraintViolationException, StaffCollectionException {
		// TODO Auto-generated method stub
//		Optional<Staff> staffOptional1= staffRepo.findByemployeeId(staff.getEmployeeId());
		//TODO emp id generation
		
		
		Optional<Staff> staffOptional= staffRepo.findByemail(staff.getEmail());
		
		
		if(staffOptional.isPresent())
        {
            throw new StaffCollectionException(StaffCollectionException.StaffAlreadyExists());
        }
		else
        {
			staffRepo.save(staff);
        }
	}

	@Override
	public List<Staff> getAllStaff() {
		List<Staff> staff = staffRepo.findAll();
		if(staff.size()>0) {
			return staff;
		}else {
			return new ArrayList<Staff>();
		}
	}

	@Override
	public Staff getSingleStaff(String id) throws StaffCollectionException {
		Optional<Staff> staffOptional = staffRepo.findById(id);
		if(!staffOptional.isPresent()) {
			//if not present
			throw new StaffCollectionException(StaffCollectionException.NotFoundException(id));
		} else {
			return staffOptional.get();
		}
	}

	@Override
	public void updateStaff(String id, Staff staff) throws StaffCollectionException {
		
		Optional<Staff> staffWithId = staffRepo.findById(id);
		Optional<Staff> staffWithSameEmail = staffRepo.findByemail(staff.getEmail());
		
		if(staffWithId.isPresent()){
			
			
			
			if(staffWithSameEmail.isPresent() && staffWithSameEmail.get().getId().equals(id)) {
				throw new StaffCollectionException(StaffCollectionException.StaffAlreadyExists()); 
			}//checks if same email is there if yes than throw an exception
			
			Staff staffToUpdate = staffWithId.get();
			
			staffToUpdate.setName(staff.getName());
			staffToUpdate.setEmail(staff.getEmail());
			staffToUpdate.setGender(staff.getGender());
			staffToUpdate.setDepartment(staff.getDepartment());
			staffToUpdate.setSalary(staff.getSalary());
			staffToUpdate.setContactNumber(staff.getContactNumber());
			staffToUpdate.setPosition(staff.getPosition());
			
			staffRepo.save(staffToUpdate);
		}
		else
		{
			throw new StaffCollectionException(StaffCollectionException.NotFoundException(id));
		}
		
		
	}

	@Override
	public void deleteStaffById(String id) throws StaffCollectionException {

		Optional<Staff> staffOptonal = staffRepo.findById(id);
		
		if(!staffOptonal.isPresent()) {
			throw new StaffCollectionException(StaffCollectionException.NotFoundException(id));
		} else {
			staffRepo.deleteById(id);
		}
		
	}

}
