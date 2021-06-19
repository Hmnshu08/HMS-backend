package com.hms.roomsearchservice.service;

import java.util.List;

import com.hms.roomsearchservice.exception.RoomCollectionException;
import com.hms.roomsearchservice.models.Room;



public interface RoomSearchService {

//	public List<Room> getAllRoom(); //get all the document method
	
//	public List<Room> findByAvailablity(String availabilty);
	
	public List<Room> findByStatus(String availabilty);

}
