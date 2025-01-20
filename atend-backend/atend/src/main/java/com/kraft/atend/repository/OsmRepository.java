package com.kraft.atend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kraft.atend.entity.OsmObject;

@Repository
public interface OsmRepository extends JpaRepository<OsmObject, Long> {

	public Optional<OsmObject> findByPlaceId(Long id);
}
