package com.kraft.atend.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ApplicationUser extends BaseEntity {
	private String name;
	private String email;
	private String googleId;
}
