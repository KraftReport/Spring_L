package com.kraft.atend.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OsmAddress extends BaseEntity {
	private String road;
	private String neighbourHood;
	private String suburb;
	private String cityDistrict;
	private String city;
	private String state;
	private String ISO3166_2_lvl4;
	private String postCode;
	private String country;
	private String countryCode;
}
