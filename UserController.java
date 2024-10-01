package com.shubham.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.payloads.ApiResponse;
import com.shubham.payloads.UserDto;
import com.shubham.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apis/users")
public class UserController {

	@Autowired
	public UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId")Integer uId){
		UserDto updateUser = this.userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updateUser);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId")Integer uId){
		this.userService.deleteUser(uId);
		return new  ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully..",true),HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getAllUsersById(@PathVariable("userId")Integer uId){
		
		return ResponseEntity.ok(this.userService.getUserById(uId));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
