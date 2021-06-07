package com.hms.userservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.userservice.models.Users;



@RestController
@RequestMapping("/users")
public class UsersResources {

	
	
	@RequestMapping("/{usersId}")
	public List<Users> getUsers(@PathVariable("usersId") String usersId){
		
		return Collections.singletonList(
				new Users("mark", "12345", "owner", "abc@gmail.com")
				);
	}
}
