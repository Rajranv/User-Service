package com.learning.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.demo.enums.Status;
import com.learning.demo.model.UserRequest;
import com.learning.demo.model.UserResponse;
import com.learning.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserResponse createNewUser(@RequestBody UserRequest userRequest) {
		return userService.create(userRequest);
	}

	@GetMapping("/{userId}")
	public UserResponse getByUserId(@PathVariable Long userId) {
		return userService.findByUserId(userId);
	}
	
	@PutMapping("/{userId}")
	public UserResponse updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
		return userService.update(id, userRequest);
	}
	
	@DeleteMapping("/{userId}")
	public Status deleteUserById(@PathVariable Long id) {
		return userService.deleteUserById(id);	
	}


}
