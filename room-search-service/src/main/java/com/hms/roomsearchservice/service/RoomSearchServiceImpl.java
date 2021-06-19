package com.hms.roomsearchservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hms.roomsearchservice.exception.RoomCollectionException;
import com.hms.roomsearchservice.models.Room;
import com.hms.roomsearchservice.repository.RoomRepository;





@Service
public class RoomSearchServiceImpl implements RoomSearchService {

	@Autowired
	private RoomRepository roomRepo;
	
	
	
//	@Override
//	public List<Room> getAllRoom() {
//		List<Room> room = roomRepo.findAll();
//		if(room.size()>0) {
//			return room;
//		}else {
//			return new ArrayList<Room>();
//		}
//	}



	@Override
	public List<Room> findByStatus(String availabilty) {
		List<Room> room = roomRepo.findByStatus("Available");
		return room;
	}



	



	



	
}
