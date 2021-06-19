package com.hms.reservationservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hms.reservationservice.exception.ReservationCollectionException;
import com.hms.reservationservice.models.Guest;
import com.hms.reservationservice.models.Reservation;
import com.hms.reservationservice.repository.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	
	@Autowired
	private ReservationRepository reservationRepo;
	

	@Override
	public void createReservation(Reservation reservation)
			throws ConstraintViolationException, ReservationCollectionException {


//		Optional<Reservation> reservationOptional= reservationRepo.findByguestCode(reservation.getGuestCode());
//		if(reservationOptional.isPresent())
//		{
//			throw new ReservationCollectionException(ReservationCollectionException.ReservationAlreadyExists());
//		}
//		else
        {
			reservationRepo.save(reservation);
        }
	}

	@Override
	public List<Reservation> getAllReservation() {
		List<Reservation> reservation = reservationRepo.findAll();
		if(reservation.size()>0) {
			return reservation;
		}else {
			return new ArrayList<Reservation>();
		}
	}

	@Override
	public Reservation getSingleReservation(String id) throws ReservationCollectionException {
		Optional<Reservation> reservationOptional = reservationRepo.findById(id);
		if(!reservationOptional.isPresent()) {
			//if not present
			throw new ReservationCollectionException(ReservationCollectionException.NotFoundException(id));
		} else {
			return reservationOptional.get();
		}
	}

	@Override
	public void updateReservation(String id, Reservation reservation) throws ReservationCollectionException {
		Optional<Reservation> reservationWithId = reservationRepo.findById(id);
		Optional<Reservation> reservationWithSameGuestCode = reservationRepo.findByguestCode(reservation.getGuestCode());
		
		if(reservationWithId.isPresent()) 
		{
			if(reservationWithSameGuestCode.isPresent()) {
				throw new ReservationCollectionException(ReservationCollectionException.ReservationAlreadyExists());
			}
			
			Reservation reservationToUpdate = reservationWithId.get();
			
			reservationToUpdate.setGuestCode(reservation.getGuestCode());
			reservationToUpdate.setCheckIn(reservation.getCheckIn());
			reservationToUpdate.setCheckOut(reservation.getCheckOut());
			reservationToUpdate.setRoomNumber(reservation.getRoomNumber());
			reservationToUpdate.setNumberOfNights(reservation.getNumberOfNights());
			reservationToUpdate.setAdults(reservation.getAdults());
			reservationToUpdate.setChildrens(reservation.getChildrens());
			reservationToUpdate.setReservationBy(reservation.getReservationBy());
			
			reservationRepo.save(reservationToUpdate);
		}
		else {
			throw new ReservationCollectionException(ReservationCollectionException.NotFoundException(id));
		}
	}

	@Override
	public void deleteReservationById(String id) throws ReservationCollectionException {
Optional<Reservation> reservationOptonal = reservationRepo.findById(id);
		
		if(!reservationOptonal.isPresent()) {
			throw new ReservationCollectionException(ReservationCollectionException.NotFoundException(id));
		} else {
			reservationRepo.deleteById(id);
		}
		
	}

	

	
	
}
