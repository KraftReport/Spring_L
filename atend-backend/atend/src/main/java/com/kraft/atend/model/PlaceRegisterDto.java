package com.kraft.atend.model;

import org.springframework.web.multipart.MultipartFile;

public record PlaceRegisterDto(
		String name,
		Double lattitude,
		Double longitude,
		MultipartFile rawFile) {

}
