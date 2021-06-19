package com.hms.roomsearchservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.roomsearchservice.models.Room;
import com.hms.roomsearchservice.repository.RoomRepository;
import com.hms.roomsearchservice.service.RoomSearchService;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@ApiOperation(value = "/search", tags = "Room Search Controller")
@RestController
public class RoomSearchController {

	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private RoomSearchService roomService;
	
	
	//getting all the documents
//	@GetMapping("search/{available}")
//	public ResponseEntity<?> getAllRoom(){
//		List<Room> room = roomService.findByAvailablity("available");
//		return new ResponseEntity<>(room,room.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
//		
//	}
	
	@ApiOperation(value = "Fetch all Users", response = Room.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "SUCCESS", response = Room.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED!", response = Room.class),
			@ApiResponse(code = 403, message = "FORBIDDEN", response = Room.class),
			@ApiResponse(code = 404, message = "NOT FOUND")
	})
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/search")
	public ResponseEntity<?> getAllRoom(){
		List<Room> room = roomService.findByStatus("Available");
		return new ResponseEntity<>(room,room.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
		
	}
	
}
