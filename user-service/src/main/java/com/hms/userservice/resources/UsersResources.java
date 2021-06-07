package com.hms.userservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hms.userservice.models.Users;



@RestController
@RequestMapping("/users")
public class UsersResources {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{usersId}")
	public List<Users> getUsers(@PathVariable("usersId") String usersId){
		
		return Collections.singletonList(
				new Users("mark", "12345", "owner", "abc@gmail.com")
				);
	}
}
