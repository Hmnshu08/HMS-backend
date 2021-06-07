package com.hms.guestservice.resources;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hms.guestservice.models.Guest;

@RestController
@RequestMapping("/guest")
public class GuestResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<Guest> getGuest(@PathVariable("userId") String userId){
		
		return Collections.singletonList(
				new Guest(12054, "aman","M", "abc@xys.com" , "toen", "delhi", "india", 110000, "voter", "565894DA", "abc", 99865954,1125484)
				);
	}
	
	
}

















