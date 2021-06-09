package com.hms.guestservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hms.guestservice.models.Guest;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String> {

	//if same email is available then exception
	@Query("{'email':?0}")
	Optional<Guest> findByemail(String email);
	
	@Query("{'contact':?0}")
	Optional<Guest> findBycontact(String contact);
	
	@Query("{'govId':?0}")
	Optional<Guest> findBygovId(String govId);
	
	
}
