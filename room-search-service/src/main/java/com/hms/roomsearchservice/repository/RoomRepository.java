package com.hms.roomsearchservice.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hms.roomsearchservice.models.Room;




@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

	
	//if same room status is available then show
//		@Query("{'status':?0}")
//		Optional <Room> findBystatus(string status);

		
//		@Query("{'status':?0}")
//		List<Room> findBystatus();
//		
		@Query("{'status':?0}")
		public List<Room> findByStatus(String availabilty);
		
//		@Query(value = "{'status':?0}",fields = "{'id' : 0}")
//		public List<Room> findByStatus(String availabilty);
}