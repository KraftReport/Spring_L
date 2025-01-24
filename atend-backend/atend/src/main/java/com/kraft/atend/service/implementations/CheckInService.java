package com.kraft.atend.service.implementations;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.kraft.atend.entity.CheckIn;
import com.kraft.atend.entity.PlaceImages;
import com.kraft.atend.model.CheckInDto;
import com.kraft.atend.model.PlaceRegisterDto;
import com.kraft.atend.repository.CheckInRepository;
import com.kraft.atend.repository.OsmRepository;
import com.kraft.atend.repository.PlaceImagesRepository;
import com.kraft.atend.service.abstractions.CheckInHandler;
import com.kraft.atend.service.abstractions.OsmHandler;
import com.kraft.atend.service.abstractions.FileHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckInService implements CheckInHandler {
	
	private final FileHandler fileHandler; 
	private final CheckInRepository checkInRepository;
	private final OsmRepository osmRepository;
	private final OsmHandler osmHandler;
	private final PlaceImagesRepository placeImagesRepository;
	
	@Override
	public boolean checkIn(CheckInDto checkInDto) throws IOException {
		
		var osmResponse = osmHandler.callOsmApi(checkInDto.latitude(), checkInDto.longitude());
		var osmRecord = osmRepository.findByPlaceId(osmResponse.getPlaceId()).orElse(null);
		
		if(osmRecord == null) {
			osmRepository.save(osmResponse);
		}
		
		var savedImagePath = fileHandler.uploadPlaceImageInResourceFolder(checkInDto.rawFile(),osmResponse.getName());
		
		var checkInRecord = new CheckIn();
		
		checkInRecord.setUserId(checkInDto.userId());
		checkInRecord.setPlaceId(osmRecord.getPlaceId());
		checkInRecord.setCheckInPhoto(savedImagePath);
		
		var placesImageRecord = new PlaceImages();
		
		placesImageRecord.setImageFilePath(savedImagePath);
		placesImageRecord.setPlaceId(osmResponse.getPlaceId());
		
 
		return checkInRepository.save(checkInRecord) != null && placeImagesRepository.save(placesImageRecord) != null;
	}
 
}
