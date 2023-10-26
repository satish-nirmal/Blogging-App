package com.codewithsatish.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.codewithsatish.blog.enitity.User;
import com.codewithsatish.blog.payload.ApiResponse;
import com.codewithsatish.blog.payload.UserDto;
import com.codewithsatish.blog.service.UserService;


@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create/user")
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto user) {

		UserDto createUser = userService.createUser(user);

		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	@PutMapping("/update/user/{id}")
	public ResponseEntity<UserDto> userUpdate(@RequestBody UserDto userDto, @PathVariable("id") long id) {

		UserDto updateUser = userService.updateUser(userDto, id);

//		return new ResponseEntity(Map.of("message", "user updated successfully "), HttpStatus.OK);

		return ResponseEntity.ok(updateUser);
	}

	@DeleteMapping("/delete/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

		userService.deleteUser(id);

		return new ResponseEntity<>(new ApiResponse("user deleted successfully", true), HttpStatus.OK);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return userService.getAll();

	}

	@GetMapping("user/{id}")
	public UserDto getUser(@PathVariable("id") long id) {

		return userService.getUser(id);
	}

}
