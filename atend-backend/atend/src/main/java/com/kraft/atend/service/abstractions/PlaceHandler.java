package com.kraft.atend.service.abstractions;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.kraft.atend.model.PlaceRegisterDto;

@Service
public interface PlaceHandler {

	public boolean registerNewPlace(PlaceRegisterDto placeRegisterDto) throws IOException;
}
