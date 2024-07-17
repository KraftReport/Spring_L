package com.sword.feat.service;

import com.sword.feat.model.Author;
import com.sword.feat.model.Book;
import com.sword.feat.repository.AuthorRepository;
import com.sword.feat.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void createBook(Book book) {
        var author = authorRepository.findById(book.getAuthor_id()).orElseThrow(()->new RuntimeException("author not found"));
        var authors = new ArrayList<Author>();
        authors.add(author);
        book.setAuthors(authors);
        bookRepository.save(book);
        authorRepository.save(author);
    }

    @Override
    public List<Book> superSearchMethod(String input) {
        System.err.println(input); 

        List<Specification<Book>> bookSpec = new ArrayList<>(); 
        bookSpec.add(BookSpecification.nameSpecification(input)); 
        bookSpec.add(BookSpecification.reviewerSpecification(input)); 
        
        Specification<Book> combineSpec = BookSpecification.authorSpecification(input).or(BookSpecification.nameSpecification(input).or(BookSpecification.reviewerSpecification(input)));
        System.err.println(BookSpecification.authorSpecification(input));
        System.err.println(BookSpecification.nameSpecification(input));
        System.err.println(BookSpecification.reviewerSpecification(input));
        System.err.println(combineSpec.toString());
        // Debugging output
        if (combineSpec != null) {
            System.err.println("Specification combined successfully.");
        } else {
            System.err.println("No specifications provided.");
        } 
 
        return bookRepository.findAll(combineSpec); // Adjusted to return paginated result
    }

}
