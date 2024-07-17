package com.sword.feat.service;

import com.sword.feat.model.Review;
import com.sword.feat.repository.BookRepository;
import com.sword.feat.repository.ReviewRepository;
import com.sword.feat.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public void createReview(Review review) {
    	var user = userRepository.findById(review.getUser_id()).orElseThrow(()->new RuntimeException("user not found"));
    	var book = bookRepository.findById(review.getBook_id()).orElseThrow(()->new RuntimeException("book not found"));
    	review.setUser(user);
    	review.setBook(book);
        reviewRepository.save(review);  
    }
}
