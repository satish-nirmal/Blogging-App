package com.codewithsatish.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsatish.blog.enitity.User;
import com.codewithsatish.blog.payload.UserDto;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public UserDto findById(long id);

}
