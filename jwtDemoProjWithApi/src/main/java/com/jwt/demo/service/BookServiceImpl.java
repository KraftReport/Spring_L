package com.jwt.demo.service;

import org.springframework.stereotype.Service;

import com.jwt.demo.DTO.BookRequest;
import com.jwt.demo.DTO.BookResponse;
import com.jwt.demo.model.Book;
import com.jwt.demo.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
	
	
	private final BookRepository bookRepository;

 
	private Book RequestToBook(BookRequest bookRequest) {
		return Book.builder()
				.name(bookRequest.getName())
				.isbn(bookRequest.getIsbn())
				.build();
	}
	
	private BookResponse BookToResponse(Book book) {
		return BookResponse.builder()
				.name(book.getName())
				.isbn(book.getIsbn())
				.build();
	}

	@Override
	public boolean saveBook(BookRequest bookrequest) {
		var book = RequestToBook(bookrequest);
		bookRepository.save(book);
		return book != null;
	}

	@Override
	public BookResponse updateBook(BookRequest bookRequest) {
		var book = bookRepository.findById(bookRequest.getId()).orElse(null);
		book.setName(bookRequest.getName());
		book.setIsbn(bookRequest.getIsbn());
		bookRepository.save(book);
		return BookToResponse(book);
	}

	 
}
