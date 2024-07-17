package com.sword.feat.controller;

import com.sword.feat.model.Author;
import com.sword.feat.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/createAuthor")
    public ResponseEntity<String > createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
        return ResponseEntity.ok("author is created");
    }
}
