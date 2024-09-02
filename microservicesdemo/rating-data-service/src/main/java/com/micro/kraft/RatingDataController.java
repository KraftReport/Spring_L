package com.micro.kraft;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratingData")
public class RatingDataController {
    public  final List<Rating> ratingList = List.of(
            new Rating(1L, 1L, 7L),
            new Rating(2L,2L,9L)
    );
    @GetMapping("/{movieId}")
    public ResponseEntity<Rating> getMovieRating(@PathVariable("movieId")String movieId){
        return ResponseEntity.ok(ratingList.stream().filter(r -> r.getMovieId().equals(Long.valueOf(movieId))).findFirst().orElse(null));
    }
}
