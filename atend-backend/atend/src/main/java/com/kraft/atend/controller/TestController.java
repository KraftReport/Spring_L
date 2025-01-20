package com.kraft.atend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kraft.atend.service.abstractions.OsmHandler;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

	private final OsmHandler osmHandler;
	
	@PostMapping("/osmapi")
	public ResponseEntity<?> testOsmApiCall(@RequestParam("latitude")double latitude,@RequestParam("longitude")double longitude){
		var object = osmHandler.callOsmApi(latitude, longitude);
		return ResponseEntity.ok(osmHandler.confirmLocation(object));
	}
}
