package com.kraft.atend.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Place extends BaseEntity {
	private String name;
	private Double lattitude;
	private Double longitude;
	private String photoPath; 
}
