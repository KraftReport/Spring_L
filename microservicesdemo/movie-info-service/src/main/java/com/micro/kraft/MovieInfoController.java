package com.micro.kraft;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movieInfo")
public class MovieInfoController {

    private final List<MovieItem> movieList = Arrays.asList(
            new MovieItem(1L,"Inception"),
            new MovieItem(2L,"DeadPool")
    );

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieItem> getMovieItem(@PathVariable("movieId")String movieId){
        return ResponseEntity.ok(movieList.stream().filter(m-> m.getMovieId().equals(Long.valueOf(movieId))).findFirst().orElse(null));
    }
}
