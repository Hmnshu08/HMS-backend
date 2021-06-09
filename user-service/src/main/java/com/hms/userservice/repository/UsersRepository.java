package com.hms.userservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.hms.userservice.models.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

	//if same email is available then exception
		@Query("{'email':?0}")
		Optional<Users> findByemail(String email);
		
//		if same username is available then exception
		@Query("{'username':?0}")
		Optional<Users> findByusername(String username);
}
