package com.hms.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hms.userservice.exception.UsersCollectionException;
import com.hms.userservice.models.Users;
import com.hms.userservice.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepo;
	
	@Override
	public void createUsers(Users users) throws ConstraintViolationException, UsersCollectionException {
		Optional<Users> usersOptional= usersRepo.findByemail(users.getEmail());
		Optional<Users> usersOptional1= usersRepo.findByusername(users.getUsername());
		
		if(usersOptional.isPresent()) {
			throw new UsersCollectionException(UsersCollectionException.UserAlreadyExists());
		}
		else if(usersOptional1.isPresent()) {
			throw new UsersCollectionException(UsersCollectionException.UserNameAlreadyExists());
		}
		else {
			usersRepo.save(users);
		}
	}

	@Override
	public List<Users> getAllUsers() {
	List<Users> users = usersRepo.findAll();
		if(users.size()>0) {
			return users;
		} else {
			return new ArrayList<Users>();
		}
		
	}

	@Override
	public Users getSingleUsers(String id) throws UsersCollectionException {
		Optional<Users> usersOptional = usersRepo.findById(id);
		if(!usersOptional.isPresent()) {
			//if not present
			throw new UsersCollectionException(UsersCollectionException.NotFoundException(id));
		} else {
			return usersOptional.get();
		}
	}
	
	
	
	
	
	

	@Override
	public void updateUsers(String id, Users users) throws UsersCollectionException {
		Optional<Users> usersWithId = usersRepo.findById(id);
		Optional<Users> usersWithSameEmail = usersRepo.findByemail(users.getEmail());
		Optional<Users> userWithSameUserName = usersRepo.findByusername(users.getUsername());
		
			if(usersWithId.isPresent()) {
				
				
				
				if(usersWithSameEmail.isPresent() && usersWithSameEmail.get().getEmail().equals(id)) {
					throw new UsersCollectionException(UsersCollectionException.UserAlreadyExists());
				}
				//checks if same email is there if yes than throw an exception
				if(userWithSameUserName.isPresent() && userWithSameUserName.get().getUsername().equals(id)) {
					throw new UsersCollectionException(UsersCollectionException.UserNameAlreadyExists());
				}
				//checks if same user name is there if yes than throw an exception
				
				
				Users usersToUpdate = usersWithId.get();
				
				usersToUpdate.setEmail(users.getEmail());
				usersToUpdate.setUsername(users.getUsername());
				usersToUpdate.setPass(users.getPass());
				usersToUpdate.setUserType(users.getUserType());
				
				usersRepo.save(usersToUpdate);
				
				
				
				
				
				
				
			} 
			else 
			{
				throw new UsersCollectionException(UsersCollectionException.NotFoundException(id));
			}
		
		
		
			
		}
	
	
	
	
	
	

	@Override
	public void deleteUsersById(String id) throws UsersCollectionException {
		// TODO Auto-generated method stub
		
		Optional<Users> usersOptonal = usersRepo.findById(id);
		
		if(!usersOptonal.isPresent()) {
			throw new UsersCollectionException(UsersCollectionException.NotFoundException(id));
		} else {
			usersRepo.deleteById(id);
		}
		
	}

}
