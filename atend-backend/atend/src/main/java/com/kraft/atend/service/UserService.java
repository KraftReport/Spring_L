package com.kraft.atend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kraft.atend.entity.ApplicationUser;
import com.kraft.atend.model.UserResponseDto;
import com.kraft.atend.repository.AuthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private AuthRepository authRepository;
	
	public List<UserResponseDto> getUserList(){
		var result = new ArrayList<UserResponseDto>();
		authRepository.findAll().forEach((user)->result.add(mapper(user)));
		return result;
	}
	
	public UserResponseDto findUserById(long id) {
		return mapper(authRepository.findById(id).orElse(null));
	}
	
	private UserResponseDto mapper(ApplicationUser applicationUser) {
		var userDto = new UserResponseDto();
		userDto.setEmail(applicationUser.getEmail());
		userDto.setName(applicationUser.getName());
		return userDto;
	}
	
	
}
