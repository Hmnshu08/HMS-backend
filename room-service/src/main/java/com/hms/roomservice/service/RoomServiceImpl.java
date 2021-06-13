package com.hms.roomservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hms.roomservice.exception.RoomCollectionException;
import com.hms.roomservice.models.Room;
import com.hms.roomservice.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepo;

	@Override
	public void createRoom(Room room) throws ConstraintViolationException, RoomCollectionException {

		Optional<Room> roomOptional= roomRepo.findByroomNumber(room.getRoomNumber());
		
		
		if(roomOptional.isPresent())
        {
            throw new RoomCollectionException(RoomCollectionException.RoomAlreadyExists());
        }
		else
        {
        	roomRepo.save(room);
        }
		
	}

	@Override
	public List<Room> getAllRoom() {
		List<Room> room = roomRepo.findAll();
		if(room.size()>0) {
			return room;
		}else {
			return new ArrayList<Room>();
		}
	}

	@Override
	public Room getSingleRoom(String id) throws RoomCollectionException {
		Optional<Room> roomOptional = roomRepo.findById(id);
		if(!roomOptional.isPresent()) {
			//if not present
			throw new RoomCollectionException(RoomCollectionException.NotFoundException(id));
		} else {
			return roomOptional.get();
		}
	}

	@Override
	public void updateRoom(String id, Room room) throws RoomCollectionException {
		Optional<Room> roomWithId = roomRepo.findById(id);
		Optional<Room> roomWithSameNumber = roomRepo.findByroomNumber(room.getRoomNumber());
		
		if(roomWithId.isPresent()){
			
			if(roomWithSameNumber.isPresent() && roomWithSameNumber.get().getId().equals(id)) {
				throw new RoomCollectionException(RoomCollectionException.RoomAlreadyExists()); 
			}//checks if same email is there if yes than throw an exception
			
			
			Room roomToUpdate = roomWithId.get();
			
			roomToUpdate.setRoomNumber(room.getRoomNumber());
			roomToUpdate.setName(room.getName());
			roomToUpdate.setDescription(room.getDescription());
			roomToUpdate.setBlock(room.getBlock());
			roomToUpdate.setFloor(room.getFloor());
			roomToUpdate.setStatus(room.getStatus());
			roomToUpdate.setRoomType(room.getRoomType());
			roomToUpdate.setStandardPrice(room.getStandardPrice());
			roomToUpdate.setFestivePrice(room.getFestivePrice());
			
			
			roomRepo.save(roomToUpdate);
			
		}
		else {
			throw new RoomCollectionException(RoomCollectionException.NotFoundException(id));
		}
	}

	@Override
	public void deleteRoomById(String id) throws RoomCollectionException {

		Optional<Room> roomOptonal = roomRepo.findById(id);
		
		if(!roomOptonal.isPresent()) {
			throw new RoomCollectionException(RoomCollectionException.NotFoundException(id));
		} else {
			roomRepo.deleteById(id);
		}
		
	}

}
