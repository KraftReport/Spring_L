package com.jwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
