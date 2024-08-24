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
    private String id;
    private String name;
    private String description;
}
