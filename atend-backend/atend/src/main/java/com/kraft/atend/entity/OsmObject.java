package com.kraft.atend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	@JsonProperty("place_id")
	private long placeId;
	@JsonProperty("licence")
	private String licence;
	@JsonProperty("osm_type")
	private String osmType;
	@JsonProperty("osm_id")
	private long osmId;
	@JsonProperty("lat")
	private double lat;
	@JsonProperty("lon")
	private double lon;
	@JsonProperty("category")
	private String category;
	@JsonProperty("type")
	private String type;
	@JsonProperty("place_rank")
	private long placeRank;
	@JsonProperty("importance")
	private double importance;
	@JsonProperty("address_type")
	private String addressType;
	@JsonProperty("name")
	private String name;
	@JsonProperty("display_name")
	private String displayName;
	
	@Embedded
	private OsmAddress address;
	
	@ElementCollection
	@JsonProperty("boundingbox")
	@CollectionTable(name = "bounding_boxes",joinColumns = @JoinColumn(name="place_id"))
	private List<String> boundingBox;
	
}
