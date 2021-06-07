package com.hms.reservationservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.reservationservice.models.Reservation;



@RestController
@RequestMapping("/reservation")
public class ReservationResource {
	
	@RequestMapping("/{reservationId}")
public List<Reservation> getReservation(@PathVariable("reservationId") String reservation){
		
		return Collections.singletonList(
				new Reservation(101, "Aman", 101, "06-05-2021", "06-05-2021","Standard" ,5, 2, 1, "shilpa")
				);
	}

}
