package com.micro.kraft;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/ratingData")
public class RatingDataController {
    @GetMapping("/{movieId}")
    public ResponseEntity<List<Rating>> getMovieRating(@PathVariable("movieId")String movieId){
        return ResponseEntity.ok(Collections.singletonList(
                new Rating(1L,Long.valueOf(movieId),8L)
        ));
    }
}
