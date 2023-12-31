package com.codewithsatish.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithsatish.blog.enitity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findById(long id);

	public User findByName(String name);

}
