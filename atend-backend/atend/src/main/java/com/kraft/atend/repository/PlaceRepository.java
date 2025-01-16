package com.kraft.atend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kraft.atend.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

	public Optional<Place> findByLatitudeAndLongitude(Double latitude,Double longitude);
}
