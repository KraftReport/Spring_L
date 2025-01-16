package com.kraft.atend.service.implementations;

import org.springframework.stereotype.Service;

import com.kraft.atend.model.PlaceRegisterDto;
import com.kraft.atend.service.abstractions.PlaceHandler;

@Service
public class PlaceService implements PlaceHandler {

	@Override
	public boolean registerNewPlace(PlaceRegisterDto placeRegisterDto) { 
		return false;
	}

}
