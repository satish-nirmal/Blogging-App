package com.codewithsatish.blog.service;

import com.codewithsatish.blog.payload.UserDto;

public interface UserService {

	public UserDto createUser(UserDto user);
	
	public UserDto updateUser(UserDto user , long id);
	
	public void deleteUser(long id);
	
//	public List<UserDto> getAll();
	
}
