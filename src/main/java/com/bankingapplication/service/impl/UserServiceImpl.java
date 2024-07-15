package com.bankingapplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bankingapplication.dto.UserDTO;
import com.bankingapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserDTO getUserById(Long id) {
		// write your logic here
		return null;
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		// write your logic here
		return null;
	}

	@Override
	public UserDTO updateUserById(Long id, UserDTO userDTO) {
		// write your logic here
		return null;
	}

	@Override
	public Boolean deleteUserById(Long id) {
		// write your logic here
		return null;
	}

	@Override
	public List<UserDTO> searchUsersByName(String name) {
		// write your logic here
		return null;
	}
}
