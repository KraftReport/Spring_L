package com.micro.kraft;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final RestTemplate restTemplate;
    private final WebClient.Builder builder;

    List<MovieCatalogItem> movieCatalog = Arrays.asList(
            new MovieCatalogItem(1L,1L,2L,null,null),
            new MovieCatalogItem(3L,1L,1L,null,null),
            new MovieCatalogItem(2L,2L,1L,null,null)
    );

    @GetMapping("/{userId}")
    public ResponseEntity<List<MovieCatalogItem>> getMovieCatalogItems(@PathVariable("userId")String userId){
        var catalog = movieCatalog.stream().filter(m->m.getUserId().equals(Long.valueOf(userId))).toList();
        return ResponseEntity.ok(
                catalog.stream().map(c ->{
                    return new MovieCatalogItem(null,
                            null,null,
                            getMovieItem(c.getMovieId()).getMovieName(),
                            getRating(c.getMovieId()).getRating());
                }).toList()
        );
    }

    private MovieItem getMovieItem(Long id){
        return builder.build()
                .get()
                .uri("http://localhost:8082/movieInfo/"+id)
                .retrieve()
                .bodyToMono(MovieItem.class)
                .block();
    }

    private Rating getRating(Long id){
       return builder.build()
                .get()
                .uri("http://localhost:8083/ratingData/"+id)
                .retrieve()
                .bodyToMono(Rating.class)
                .block();
    }
}
