package com.kraft.atend.service;

import org.springframework.stereotype.Service;

import com.kraft.atend.entity.ApplicationUser;
import com.kraft.atend.model.UserRegisterDto;
import com.kraft.atend.model.UserRegisterModel;
import com.kraft.atend.repository.AuthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final AuthRepository authRepository;
	
	public boolean registerUser(UserRegisterDto userRegisterDto) {
		var entity = new ApplicationUser();
		entity.setName(userRegisterDto.name());
		entity.setEmail(userRegisterDto.email());
		entity.setGoogleId(userRegisterDto.googleId());
		return authRepository.save(entity) != null;
	}

}
