package com.sword.feat.repository;

import com.sword.feat.model.Book;
import com.sword.feat.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> , JpaSpecificationExecutor<Book> {
}
