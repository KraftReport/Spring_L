package com.sword.feat.service;

import com.sword.feat.model.Author;
import com.sword.feat.model.Book;
import com.sword.feat.model.Review;
import com.sword.feat.model.User;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

public class BookSpecification {

    public static Specification<Book> authorSpecification(String author) {
        return (root, query, criteriaBuilder) -> {
            Join<Book, Author> authors = root.join("authors");
            return criteriaBuilder.equal(authors.get("name"),author);
        };
    }

    public static Specification<Book> nameSpecification(String bookName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"),  bookName);
    }

    public static Specification<Book> reviewerSpecification(String name) {
        return (root, query, criteriaBuilder) -> {
            Join<Book, Review> bookReviewJoin = root.join("reviewList");
            Join<Review, User> reviewUserJoin = bookReviewJoin.join("user");
            return criteriaBuilder.equal(reviewUserJoin.get("name"), name);
        };
    }
}
