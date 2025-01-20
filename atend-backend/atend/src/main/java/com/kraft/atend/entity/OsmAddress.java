package com.kraft.atend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OsmAddress   {
	
	@JsonProperty("road")
	private String road;
	@JsonProperty("neighbourhood")
	private String neighbourHood;
	@JsonProperty("suburb")
	private String suburb;
	@JsonProperty("city_district")
	private String cityDistrict;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("ISO3166-2-lvl4")
	private String ISO3166_2_lvl4;
	@JsonProperty("post_code")
	private String postCode;
	@JsonProperty("country")
	private String country;
	@JsonProperty("country_code")
	private String countryCode;
}
