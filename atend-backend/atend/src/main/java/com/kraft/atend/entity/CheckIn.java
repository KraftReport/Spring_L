package com.kraft.atend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CheckIn extends BaseEntity {
	private Long userId;
	private Long placeId;
	private LocalDateTime checkInDateTime = LocalDateTime.now();
}
