package com.kraft.atend.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kraft.atend.model.PlaceRegisterDto;
import com.kraft.atend.service.abstractions.PlaceHandler;
import com.kraft.atend.service.implementations.PlaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor
public class PlaceController {

	private final PlaceHandler placeHandler;
	
	@PostMapping("/do-register")
	public ResponseEntity<?> registerPlace(@RequestBody PlaceRegisterDto placeRegisterDto) throws IOException{
		return ResponseEntity.ok(placeHandler.registerNewPlace(placeRegisterDto));
	}
	
}
