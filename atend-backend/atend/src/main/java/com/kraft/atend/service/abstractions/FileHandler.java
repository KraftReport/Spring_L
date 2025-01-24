package com.kraft.atend.service.abstractions;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kraft.atend.model.PlaceRegisterDto;

@Service
public interface FileHandler {

	public String uploadPlaceImageInResourceFolder(MultipartFile file, String name) throws IOException;
	 
}
