package com.home.boot.boot2.model.repository;

import com.home.boot.boot2.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Integer> {
    Video save(Video video);
}
