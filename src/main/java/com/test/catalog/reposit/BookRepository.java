package com.test.catalog.reposit;

import com.test.catalog.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OleksiiPa on 22.09.2016.
 */

@Repository
public class BookRepository {

    private Map<String, Book> dataBase;

    public BookRepository() {
        dataBase = new HashMap<>();
    }

    synchronized public void insertOrUpdate(Book book) {
       dataBase.put(book.getId(), book);
    }

    public List<Book> selectAllBooks() {
        return new ArrayList<>(dataBase.values());
    }
}
