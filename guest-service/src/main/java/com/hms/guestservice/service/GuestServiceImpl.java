package com.hms.guestservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.guestservice.exception.GuestCollectionException;
import com.hms.guestservice.models.Guest;
import com.hms.guestservice.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository guestRepo;
	
	@Override
	public void createGuest(Guest guest) throws ConstraintViolationException, GuestCollectionException  {
		// TODO Auto-generated method stub
		Optional<Guest> guestOptional= guestRepo.findByemail(guest.getEmail());
		Optional<Guest> guestOptional1= guestRepo.findBycontact(guest.getContact());
		Optional<Guest> guestOptional2= guestRepo.findBygovId(guest.getGovId());
		Optional<Guest> guestOptional3= guestRepo.findByguestCode(guest.getGuestCode());
		
		
		
		if(guestOptional.isPresent())
        {
            throw new GuestCollectionException(GuestCollectionException.GuestAlreadyExists());
        }
		else if(guestOptional1.isPresent()) {
			throw new GuestCollectionException(GuestCollectionException.ContactAlreadyExists());
		}
		else if(guestOptional2.isPresent()) {
			throw new GuestCollectionException(GuestCollectionException.GovIdAlreadyExists());
		}
		else if(guestOptional3.isPresent()) {
			throw new GuestCollectionException(GuestCollectionException.GuestCodeAlreadyExists());
		}
        else
        {
        	guestRepo.save(guest);
        }
		
	}

	@Override
	public List<Guest> getAllGuest() {
		List<Guest> guest = guestRepo.findAll();
		if(guest.size()>0) {
			return guest;
		}else {
			return new ArrayList<Guest>();
		}
	}

	@Override
	public Guest getSingleGuest(String id) throws GuestCollectionException {
		Optional<Guest> guestOptional = guestRepo.findById(id);
		if(!guestOptional.isPresent()) {
			//if not present
			throw new GuestCollectionException(GuestCollectionException.NotFoundException(id));
		} else {
			return guestOptional.get();
		}
	}

	@Override
	public void updateGuest(String id, Guest guest) throws GuestCollectionException {
		Optional<Guest> guestWithId = guestRepo.findById(id);
		Optional<Guest> guestWithSameEmail = guestRepo.findByemail(guest.getEmail());
		Optional<Guest> guestWithSameContactNumber = guestRepo.findBycontact(guest.getContact());
		Optional<Guest> guestWithSamegovId = guestRepo.findBygovId(guest.getGovId());
		
		if(guestWithId.isPresent()){
			
			//comment if cannot update the guest document
			
			if(guestWithSameEmail.isPresent() && guestWithSameEmail.get().getId().equals(id)) {
				throw new GuestCollectionException(GuestCollectionException.GuestAlreadyExists()); 
			}//checks if same email is there if yes than throw an exception
			
			if(guestWithSameContactNumber.isPresent() && guestWithSameContactNumber.get().getContact().equals(id)) {
				throw new GuestCollectionException(GuestCollectionException.ContactAlreadyExists()); 
			}//checks if same contact number is there, if yes than throws an exception
			
			if(guestWithSamegovId.isPresent() && guestWithSamegovId.get().getGovId().equals(id)) {
				throw new GuestCollectionException(GuestCollectionException.GovIdAlreadyExists()); 
			}//checks if same government Id is there, if yes than throws an exception
			
			
//			else update and save
			
			
			Guest guestToUpdate = guestWithId.get();
			
			guestToUpdate.setGuestCode(guest.getGuestCode());
			guestToUpdate.setName(guest.getName());
			guestToUpdate.setGender(guest.getGender());
			guestToUpdate.setEmail(guest.getEmail());
			guestToUpdate.setCity(guest.getCity());
			guestToUpdate.setState(guest.getState());
			guestToUpdate.setCountry(guest.getCountry());
			guestToUpdate.setPostalCode(guest.getPostalCode());
			guestToUpdate.setIdType(guest.getIdType());
			guestToUpdate.setGovId(guest.getGovId());
			guestToUpdate.setAddresss(guest.getAddresss());
			guestToUpdate.setContact(guest.getContact());
			guestToUpdate.setPhone(guest.getPhone());
			guestRepo.save(guestToUpdate);
			
			
		} else {
			throw new GuestCollectionException(GuestCollectionException.NotFoundException(id));
		}
		
		
	}

	@Override
	public void deleteGuestById(String id) throws GuestCollectionException {
		// TODO Auto-generated method stub
		Optional<Guest> guestOptonal = guestRepo.findById(id);
		
		if(!guestOptonal.isPresent()) {
			throw new GuestCollectionException(GuestCollectionException.NotFoundException(id));
		} else {
			guestRepo.deleteById(id);
		}
	}

}
