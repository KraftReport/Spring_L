package com.kraft.atend.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kraft.atend.annotations.JwtFilter;
import com.kraft.atend.model.CheckInDto;
import com.kraft.atend.service.abstractions.CheckInHandler;
import com.kraft.atend.service.implementations.CheckInService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/check-in")
@RequiredArgsConstructor
public class CheckInController {
	
	private final CheckInHandler checkInHandler;
	
	 @PostMapping()
	 @JwtFilter
	 public ResponseEntity<Boolean> checkIn(@RequestParam("latitude")double latitude,@RequestParam("longitude")double longitude){
		 return ResponseEntity.ok(checkInHandler.checkIn(latitude,latitude));
	 }
}
