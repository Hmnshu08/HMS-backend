package com.hms.roomservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.hms.roomservice.models.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

	
	//if same room Number is available then exception
		@Query("{'roomNumber':?0}")
		Optional<Room> findByroomNumber(int i);
}
