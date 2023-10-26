package com.codewithsatish.blog.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto user) {

		User dtoToUser = this.dtoToUser(user);
		User savedUser = userRepository.save(dtoToUser);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, long id) {

		this.userRepository.findById(id);

		return null;
//				this.userToDto(dtoToUser);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	public UserDto getById(long id) {

		User user = userRepository.findById(id);

		return this.userToDto(user);
	}

//	@Override
//	public UserDto getUserById(Integer userId) {
//	User user = this.userRepo.findById(userId)
//			
//	.orElse Throw (() -> new ResourceNotFoundException ("User, "id",id);
//	return this. userToDto (user);
//	}

	@Override
	public UserDto getUser(long id) {

		User dbUser = userRepository.findById(id);

		return null;
	}

	public User dtoToUser(UserDto userDto) {

		User user1 = this.modelMapper.map(userDto, User.class);

		return user1;
	}

	public UserDto userToDto(User user) {

		UserDto userDto = this.modelMapper.map(user, UserDto.class);

		return userDto;
	}

}
