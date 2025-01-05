package com.kraft.atend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kraft.atend.entity.ApplicationUser;

@Repository
public interface AuthRepository extends JpaRepository<ApplicationUser, Long> {

}
