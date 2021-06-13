package com.hms.reservationservice.controller;

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
import org.springframework.web.client.RestTemplate;

import com.hms.reservationservice.exception.ReservationCollectionException;
import com.hms.reservationservice.models.Reservation;
import com.hms.reservationservice.repository.ReservationRepository;
import com.hms.reservationservice.service.ReservationService;



@RestController
//@RequestMapping("/api")
public class ReservationController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/reservation")
	public ResponseEntity<?> getAllReservation(){
		
		
		
		List<Reservation> reservation = reservationService.getAllReservation();
		return new ResponseEntity<>(reservation,reservation.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
		
	}
	
	
//	@GetMapping("/{guestCode}")
//	public Reservation getGuest(@PathVariable("guestCode") int guestCode) {
//		return guest.stream().map()
//		restTemplate.getForEntity("http://localhost:8081/guest" + guest.getguestCode(),Guest.class);
//		
//		
//		
//	}
	
	
	
	//adding a new document
	@PostMapping("/reservation")
	public ResponseEntity<?> createReservation(@RequestBody Reservation reservation){
		try {


//			now we need service to call the method
			reservationService.createReservation(reservation);
			return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
		}
		catch(ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		}catch (ReservationCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	//getting the document by id
	@GetMapping("/reservation/{id}")
	public ResponseEntity<?> getSingleReservation(@PathVariable("id") String id){
		
		try {
			return new ResponseEntity<>(reservationService.getSingleReservation(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
	
	
	
	//update mapping
	@PutMapping("/reservation/{id}")
	public ResponseEntity<?> updateReservation(@PathVariable("id") String id,@RequestBody Reservation reservation){
		
		try {
			reservationService.updateReservation(id, reservation);
			return new ResponseEntity<>("Updated reservation with id" +id ,HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		} catch(ReservationCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		

	}
	
	
	@DeleteMapping("/reservation/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id){
		try {
//			reservationRepo.deleteById(id);
			reservationService.deleteReservationById(id);
			return new ResponseEntity<>("Successfully deleted with id" +id, HttpStatus.OK);
		}catch (ReservationCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	

}
