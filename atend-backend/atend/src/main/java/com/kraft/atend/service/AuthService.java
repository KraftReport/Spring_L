package com.kraft.atend.service;

import java.time.LocalDateTime;

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
	
	public ApplicationUser authenticate(UserRegisterDto userRegisterDto) {
		var user = authRepository.findByGoogleId(userRegisterDto.googleId());
		if(user!=null) {
			user.setUpdatedDate(LocalDateTime.now());
			authRepository.save(user);
			return user;
		}
		var entity = new ApplicationUser();
		entity.setName(userRegisterDto.name());
		entity.setEmail(userRegisterDto.email());
		entity.setGoogleId(userRegisterDto.googleId());
		return authRepository.save(entity);
	} 

}
