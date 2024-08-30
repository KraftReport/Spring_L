package com.micro.kraft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Rating {
    private Long id;
    private Long movieId;
    private Long Rating;
}
