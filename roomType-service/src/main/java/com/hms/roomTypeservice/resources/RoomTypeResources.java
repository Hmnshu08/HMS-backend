package com.hms.roomTypeservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.roomTypeservice.models.RoomType;



@RestController
@RequestMapping("/roomtype")
public class RoomTypeResources {

	@RequestMapping("/{roomtypeId}")
	public List<RoomType> RoomTypeGuest(@PathVariable("roomtypeId") String roomtypeId){
		
		return Collections.singletonList(
				new RoomType("standard", "A standard economic rest room with basic essential requirements.", "available", 800,1000)
				);
	}
}
