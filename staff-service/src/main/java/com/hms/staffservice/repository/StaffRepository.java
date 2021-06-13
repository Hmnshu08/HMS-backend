package com.hms.staffservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.hms.staffservice.models.Staff;


@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {

	//if same email is available then exception
		@Query("{'email':?0}")
		Optional<Staff> findByemail(String email);
		
//		@Query("{'employeeId':?0}")
//		Optional<Staff> findByemployeeId(String employeeId);
}
