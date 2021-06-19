package com.hms.roomservice.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.roomservice.exception.RoomCollectionException;
import com.hms.roomservice.models.Room;
import com.hms.roomservice.repository.RoomRepository;
import com.hms.roomservice.service.RoomService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@ApiOperation(value = "/room", tags = "Room Controller")
@RestController
//@RequestMapping("/api")
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private RoomService roomService;
	
	//getting all the documents
		@ApiOperation(value = "Fetch all rooms", response = Room.class)
		@ApiResponses(value= {
				@ApiResponse(code = 200, message = "SUCCESS", response = Room.class),
				@ApiResponse(code = 401, message = "UNAUTHORIZED!", response = Room.class),
				@ApiResponse(code = 403, message = "FORBIDDEN", response = Room.class),
				@ApiResponse(code = 404, message = "NOT FOUND")
		})
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/room")
		public ResponseEntity<?> getAllRoom(){
			List<Room> room = roomService.getAllRoom();
			return new ResponseEntity<>(room,room.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
			
		}
		
		
		
		//adding a new document
		@ApiOperation(value = "Post a new room", response = Room.class)
		@CrossOrigin(origins = "http://localhost:3000")
		@PostMapping("/room")
		public ResponseEntity<?> createRoom(@RequestBody Room room){
			try {

//				roomRepo.save(room);
//				now we need service to call the method
				roomService.createRoom(room);
				return new ResponseEntity<Room>(room,HttpStatus.OK);
			}
			catch(ConstraintViolationException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			}catch (RoomCollectionException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
			}
		}
		
		
		
		
		@ApiOperation(value = "Get a room by Id", response = Room.class)
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/room/{id}")
		public ResponseEntity<?> getSingleRoom(@PathVariable("id") String id){
			
			try {
				return new ResponseEntity<>(roomService.getSingleRoom(id),HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
		
		
		//update mapping
		@ApiResponse(code = 200, message = "SUCCESS", response = Room.class, responseContainer = "List")
		@ApiOperation(value = "Update a room by Id", response = Room.class)
		@CrossOrigin(origins = "http://localhost:3000")
		@PutMapping("/room/{id}")
		public ResponseEntity<?> updateRoom(@PathVariable("id") String id,@RequestBody Room room)
		{
			
			try {
				roomService.updateRoom(id, room);
				return new ResponseEntity<>("Updated room with id" +id ,HttpStatus.OK);
			} catch (ConstraintViolationException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			} catch(RoomCollectionException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
		
		@ApiOperation(value = "Delete a room by Id", response = Room.class)	
		@CrossOrigin(origins = "http://localhost:3000")
		@DeleteMapping("/room/{id}")
		public ResponseEntity<?> deleteById(@PathVariable("id") String id){
			try {
//				roomRepo.deleteById(id);
				roomService.deleteRoomById(id);
				return new ResponseEntity<>("Successfully deleted with id" +id, HttpStatus.OK);
			}catch (RoomCollectionException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
		
		

}
