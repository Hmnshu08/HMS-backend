package com.hms.roomservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.roomservice.models.Room;



@RestController
@RequestMapping("/room")
public class RoomResource {

	
	@RequestMapping("/{roomId}")
	public List<Room> getRoom(@PathVariable("roomId") String roomId){
		
		return Collections.singletonList(
				new Room(101, "sun Shine", "A", 1, "available", "standard")
				);
	}
}
