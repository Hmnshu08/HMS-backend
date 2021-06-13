package com.hms.reservationservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.hms.reservationservice.models.Reservation;



@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
	@Query("{'guestCode':?0}")
	Optional<Reservation> findByguestCode(int reservation);
}
