package com.shubham.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubham.entities.User;
import com.shubham.payloads.UserDto;
import com.shubham.repositories.UserRepo;

public interface UserService {

		
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
	
	
}
