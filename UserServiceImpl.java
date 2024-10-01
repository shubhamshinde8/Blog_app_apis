package com.shubham.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.entities.User;
import com.shubham.execption.ResourceNotFoundExecption;
import com.shubham.payloads.UserDto;
import com.shubham.repositories.UserRepo;
import com.shubham.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.usetToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user=this.userRepo.findById(userId)
				          .orElseThrow(()->new ResourceNotFoundExecption("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
	   User updatedUser = this.userRepo.save(user);
	   UserDto usetToUserDto1 = this.usetToUserDto(updatedUser);
	   
	   return usetToUserDto1;
	   
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId).
				                orElseThrow(()->new ResourceNotFoundExecption("User", "id", userId));
		
		return this.usetToUserDto(user);
		
	}

	@Override
	public List<UserDto> getAllUsers() {
		
    	List<User> users = this.userRepo.findAll();
    	List<UserDto> userDtos=users.stream().map(user->this.usetToUserDto(user)).collect(Collectors.toList());
    	return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
	    
	   User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExecption("name", "id",userId));
	   this.userRepo.delete(user);
		
	}
	
	private User dtoToUser(UserDto userDto) {	
		User user=this.mapper.map(userDto, User.class);
		return user;
	}

	private UserDto usetToUserDto(User user) {
		UserDto userDto=this.mapper.map(user, UserDto.class);
		return userDto;
	}
}
