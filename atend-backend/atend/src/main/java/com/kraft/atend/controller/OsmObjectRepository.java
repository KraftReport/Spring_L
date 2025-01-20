package com.kraft.atend.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kraft.atend.entity.OsmObject;

@Repository
public interface OsmObjectRepository extends JpaRepository<OsmObject, Long> {

}
