package com.hms.roomservice.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.hms.roomservice.exception.RoomCollectionException;
import com.hms.roomservice.models.Room;
import com.hms.roomservice.repository.RoomRepository;
import com.hms.roomservice.service.RoomService;



@RestController
//@RequestMapping("/api")
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private RoomService roomService;
	
	//getting all the documents
		@GetMapping("/room")
		public ResponseEntity<?> getAllRoom(){
			List<Room> room = roomService.getAllRoom();
			return new ResponseEntity<>(room,room.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND);
			
		}
		
		
		
		//adding a new document
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
		
		
		
		
		
		@GetMapping("/room/{id}")
		public ResponseEntity<?> getSingleRoom(@PathVariable("id") String id){
			
			try {
				return new ResponseEntity<>(roomService.getSingleRoom(id),HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		}
		
		
		//update mapping
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
