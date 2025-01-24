package com.kraft.atend.service.implementations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
 
import com.kraft.atend.model.PlaceRegisterDto; 
import com.kraft.atend.service.abstractions.FileHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService implements FileHandler {

	private static final String RESOURCE_FOLDER = "src/main/resources/static/uploads"; 
 
	@Override
	public String uploadPlaceImageInResourceFolder(MultipartFile file, String name) throws IOException { 
		
		var randomId = UUID.randomUUID().toString();
		
		var resourceFolder = Paths.get(RESOURCE_FOLDER);
		
		checkFolder(resourceFolder);
		
		var filePath = resourceFolder.resolve(name.concat(randomId).concat(getExtension(file)));
		
		file.transferTo(filePath);
		
		return filePath.toString();
	}

	private String getExtension(MultipartFile file) {
		var rawFileName = file.getOriginalFilename();
		
		return rawFileName.substring(rawFileName.lastIndexOf("."));
	}

	private void checkFolder(Path folderPath) throws IOException {
		if (!Files.exists(folderPath)) {
			Files.createDirectories(folderPath);
		}
	}

}
