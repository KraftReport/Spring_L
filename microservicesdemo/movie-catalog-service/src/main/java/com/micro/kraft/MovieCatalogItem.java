package com.micro.kraft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class MovieCatalogItem {
    private Long id;
    private Long userId;
    private Long movieId;
    private String movieName;
    private Long movieRating;
}
