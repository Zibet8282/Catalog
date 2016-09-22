package com.test.catalog.service;

import com.test.catalog.domain.Book;
import com.test.catalog.domain.Catalog;
import com.test.catalog.reposit.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OleksiiPa on 21.09.2016.
 */
@Service
public class ChangeBookServiceImpl implements ChangeBookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Catalog changeBook(Catalog catalog) {
        for (Book book : catalog.getBooks()) {
            bookRepository.insertOrUpdate(book);
        }
        Catalog response = new Catalog();
        response.setBooks(bookRepository.selectAllBooks());
       return response;
    }
}
