package com.kraft.atend.service.abstractions;

import org.springframework.stereotype.Service;

import com.kraft.atend.entity.OsmObject;

@Service
public interface OsmHandler {

	public long confirmLocation(OsmObject osmObject);
	
	public OsmObject callOsmApi(String latitude,String longitude);
	
}
