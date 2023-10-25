package com.codewithsatish.blog.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsatish.blog.enitity.User;
import com.codewithsatish.blog.payload.UserDto;
import com.codewithsatish.blog.repository.UserRepository;
import com.codewithsatish.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {

		User dtoToUser = this.dtoToUser(user);
		User savedUser = userRepository.save(dtoToUser);
		return this.userToDto(savedUser);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	public User dtoToUser(UserDto user) {

		User user1 = new User();
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setAbout(user.getAbout());
		user1.setPassword(user.getPassword());

		return user1;
	}

	public UserDto userToDto(User user) {

		UserDto userDto = new UserDto();
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getPassword());

		return userDto;
	}

	@Override
	public UserDto updateUser(UserDto user, long id) {
		UserDto dbUser = userRepository.findById(id);
		User dtoToUser = this.dtoToUser(user);
		dbUser.setName(dtoToUser.getName());
		dbUser.setAbout(dtoToUser.getAbout());
		dbUser.setEmail(dtoToUser.getEmail());
		dbUser.setPassword(dtoToUser.getPassword());
		userRepository.save(dtoToUser);
		return this.userToDto(dtoToUser);
	}

//	@Override
//	public List<UserDto> getAll() {
//		List<User> findAllUsers = userRepository.findAll();
//		User allUser = this.dtoToUser((UserDto) findAllUsers);
//		return this.dtoToUser(allUser);
//	}

}
