package com.techsorcerer.userLogin.service;

import com.techsorcerer.userLogin.entity.UserEntity;
import com.techsorcerer.userLogin.userdto.UserDto;

public interface UserService {
	UserEntity registerUser(UserDto user);

	boolean authenticateUser(String username, String password);
}
