package com.home.boot.boot2.model.repository;

import com.home.boot.boot2.model.Author;
import jakarta.persistence.NamedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Modifying
    @Transactional
    @Query("update Author a set a.firstName = :firstName ,a.lastName = :lastName where id = :id")
    void updateNameById(String firstName,String lastName,int id);

    @Transactional
    @Modifying
    void updateAge(@Param("age")int age);
    List<Author> findByCoursesDescription(String course);
    List<Author> findByFirstName(String name);

    List<Author> findByFirstNameIn(String[] names);
}
