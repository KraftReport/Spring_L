package com.kraft.atend.service;

import org.springframework.stereotype.Service;

@Service
public abstract class TokenHandler {

	public abstract String generateToken(Long id);
}
