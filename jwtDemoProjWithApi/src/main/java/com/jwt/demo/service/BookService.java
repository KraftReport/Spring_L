package com.jwt.demo.service;

import com.jwt.demo.DTO.BookRequest;
import com.jwt.demo.DTO.BookResponse;

public interface BookService {
	
	boolean saveBook(BookRequest bookrequest);
	BookResponse updateBook(BookRequest bookRequest);

}
