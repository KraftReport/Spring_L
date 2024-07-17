package com.sword.feat.service;

import com.sword.feat.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    void createBook(Book book);
    List<Book> superSearchMethod(String input );

}
