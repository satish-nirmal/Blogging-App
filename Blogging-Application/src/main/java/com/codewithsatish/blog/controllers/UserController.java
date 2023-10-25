package com.codewithsatish.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsatish.blog.payload.UserDto;
import com.codewithsatish.blog.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create/user")
	public UserDto create(@RequestBody UserDto user) {

		return userService.createUser(user);
	}
	
	@PutMapping("/update/user/{id}")
	public UserDto userUpdate(@RequestBody UserDto user, @PathVariable("id") long id) {
		
		return userService.updateUser(user, id);
	}

	@DeleteMapping("/delete/user/{id}")
	public void deleteUser(@PathVariable("id") long id) {

		userService.deleteUser(id);
	}

}
