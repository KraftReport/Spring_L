package com.micro.kraft;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieInfo")
public class MovieInfoController {

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieItem> getMovieItem(@PathVariable("movieId")String movieId){
        return ResponseEntity.ok(new MovieItem("one","Inception"));
    }
}
