package com.kraft.atend.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PlaceImages extends BaseEntity {

	private Long placeId;
	private String imageFilePath;
	
}
