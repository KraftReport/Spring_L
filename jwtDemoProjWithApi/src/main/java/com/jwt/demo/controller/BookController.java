package com.jwt.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.demo.DTO.BookRequest;
import com.jwt.demo.DTO.BookResponse;
import com.jwt.demo.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor
@RequestMapping("/book") 
public class BookController {
	
	private final BookService bookService;
	
	@PostMapping("/createBook")
	public ResponseEntity<Boolean> createBook(@RequestBody BookRequest bookRequest){
		bookService.saveBook(bookRequest);
		return ResponseEntity.ok(true);
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity<BookResponse> updateBook(@RequestBody BookRequest bookRequest){
		return ResponseEntity.ok(bookService.updateBook(bookRequest));
	}

}
