package com.codewithsatish.blog.service;

import java.util.List;

import com.codewithsatish.blog.enitity.User;
import com.codewithsatish.blog.payload.UserDto;

public interface UserService {

	public UserDto createUser(UserDto user);
	
	public UserDto updateUser(UserDto userDto , long id);
	
	public void deleteUser(long id);
	
	public List<User> getAll();
	
	public UserDto getUser(long id);
	
}
