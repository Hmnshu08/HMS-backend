package com.hms.roomTypeservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hms.roomTypeservice.models.RoomType;



@RestController
@RequestMapping("/roomtype")
public class RoomTypeResources {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{roomtypeId}")
	public List<RoomType> RoomTypeGuest(@PathVariable("roomtypeId") String roomtypeId){
		
		return Collections.singletonList(
				new RoomType("standard", "A standard economic rest room with basic essential requirements.", "available", 800,1000)
				);
	}
}
