package com.techsorcerer.userLogin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsorcerer.userLogin.entity.UserEntity;
import com.techsorcerer.userLogin.exceptions.AuthenticationFailedException;
import com.techsorcerer.userLogin.exceptions.UsernameExistsException;
import com.techsorcerer.userLogin.repository.UserRepository;
import com.techsorcerer.userLogin.service.UserService;
import com.techsorcerer.userLogin.userdto.UserDto;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity registerUser(UserDto userDto) {
		
		if(userRepository.findByUsername(userDto.getUsername())!= null){
			throw new UsernameExistsException("Username already exists");
		}
		
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setUsername(userDto.getUsername());
		userEntity.setPassword(userDto.getPassword());
		
		return userRepository.save(userEntity);
	}

	@Override
	public boolean authenticateUser(String username, String password) {
		
		UserEntity userEntity = userRepository.findByUsername(username);
		
		if(userEntity == null || !userEntity.getPassword().equals(password) ) {
			throw new AuthenticationFailedException("Username or password do not match.");
		}
		return true;
	}

}
