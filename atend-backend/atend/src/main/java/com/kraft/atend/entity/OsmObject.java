package com.kraft.atend.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OsmObject extends BaseEntity {

	private long placeId;
	private String licence;
	private String osmType;
	private long osmId;
	private double lat;
	private double lon;
	private String category;
	private String type;
	private long placeRank;
	private double importance;
	private String addressType;
	private String name;
	private String displayName;
	
	@Embedded
	private OsmAddress address;
	
	@ElementCollection
	@CollectionTable(name = "bounding_boxes",joinColumns = @JoinColumn(name="place_id"))
	private List<String> boundingBox;
	
}
