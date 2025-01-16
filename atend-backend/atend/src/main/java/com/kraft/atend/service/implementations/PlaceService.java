package com.kraft.atend.service.implementations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kraft.atend.entity.Place;
import com.kraft.atend.model.PlaceRegisterDto;
import com.kraft.atend.repository.PlaceRepository;
import com.kraft.atend.service.abstractions.PlaceHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceService implements PlaceHandler {

	private static final String RESOURCE_FOLDER = "src/main/resources/static/uploads";
	private final PlaceRepository placeRepository;

	@Override
	public boolean registerNewPlace(PlaceRegisterDto placeRegisterDto) throws IOException {
		var entity = new Place();
		
		entity.setName(placeRegisterDto.name());
		entity.setPhotoPath(uploadFile(placeRegisterDto.rawFile(), placeRegisterDto.name()));
		entity.setLattitude(placeRegisterDto.lattitude());
		entity.setLongitude(placeRegisterDto.longitude());
		
		return !placeRepository.save(entity).equals(null);
	}

	private String uploadFile(MultipartFile file, String name) throws IOException { 
		var resourceFolder = Paths.get(RESOURCE_FOLDER);
		
		checkFolder(resourceFolder);
		
		var filePath = resourceFolder.resolve(name.concat(getExtension(file)));
		
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
