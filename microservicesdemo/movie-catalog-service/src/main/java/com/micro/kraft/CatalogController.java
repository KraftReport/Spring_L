package com.micro.kraft;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @GetMapping("/{userId}")
    public ResponseEntity<List<MovieCatalogItem>> getMovieCatalogItems(@PathVariable("userId")String userId){
        return ResponseEntity.ok(Collections.singletonList(
                new MovieCatalogItem("one","Inception","movie about hypnosis")
        ));
    }
}
