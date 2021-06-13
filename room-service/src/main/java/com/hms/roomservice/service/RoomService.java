package com.hms.roomservice.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.hms.roomservice.exception.RoomCollectionException;
import com.hms.roomservice.models.Room;


public interface RoomService {

public void createRoom(Room room) throws ConstraintViolationException, RoomCollectionException;
	
	public List<Room> getAllRoom();//get all the document method
	
	public Room getSingleRoom(String id) throws RoomCollectionException; //get a single document through this method
	
	public void updateRoom(String id, Room room) throws RoomCollectionException; //update a document
	
	public void deleteRoomById(String id) throws RoomCollectionException;//delete a document from room
	
}
