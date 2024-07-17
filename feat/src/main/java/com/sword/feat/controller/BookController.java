package com.sword.feat.controller;

import com.sword.feat.model.Book;
import com.sword.feat.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity<String> createBook(@RequestBody Book book){
        bookService.createBook(book);
        return ResponseEntity.ok("book is created");
    }
    
    @GetMapping("/superSearch/{input}")
    public ResponseEntity<List<Book>> superSearch(@PathVariable(value = "input") String input){
    	System.err.println(input);
    	var list = bookService.superSearchMethod(input);
    	System.err.println(list+"this is the result");
        return ResponseEntity.ok(bookService.superSearchMethod(input));
    }
}
