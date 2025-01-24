package com.kraft.atend.service.abstractions;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.kraft.atend.model.CheckInDto;

@Service
public interface CheckInHandler {
 
	public boolean checkIn(CheckInDto checkInDto) throws IOException;
	
}
