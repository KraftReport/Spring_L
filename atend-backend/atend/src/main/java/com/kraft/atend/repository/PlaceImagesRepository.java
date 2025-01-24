package com.kraft.atend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kraft.atend.entity.PlaceImages;

@Repository
public interface PlaceImagesRepository extends JpaRepository<PlaceImages, Long> {

}
