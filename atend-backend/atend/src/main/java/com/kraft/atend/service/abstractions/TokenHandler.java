package com.kraft.atend.service.abstractions;

import org.springframework.stereotype.Service;

@Service
public abstract class TokenHandler {

	public abstract String generateToken(Long id);
}
