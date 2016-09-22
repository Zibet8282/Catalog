package com.test.catalog.service;

import com.test.catalog.domain.Book;
import com.test.catalog.domain.Catalog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by OleksiiPa on 22.09.2016.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfig.class})
public class ChangeBookServiceTest {

    @Autowired
    ChangeBookService changeBookService;

    @Test
    public void changeBook() throws Exception {
        assertThat(changeBookService, instanceOf(ChangeBookServiceImpl.class));
    }

    @Test
    public void changeBookLogic() throws Exception {
        Catalog catalog = new Catalog();
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setId(String.valueOf(i));
            bookList.add(book);
        }
        catalog.setBooks(bookList);
        final Catalog respCatalog = changeBookService.changeBook(catalog);

        for (int i = 0; i < 5; i++) {
            assertEquals(respCatalog.getBooks().get(i).getId(), String.valueOf(i));
        }
    }

    @Test
    public void changeBookLogicExists() throws Exception {
        Catalog catalog = new Catalog();
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setId(String.valueOf(i));
            book.setAuthor(String.format("Author %d", i));
            bookList.add(book);
        }
        catalog.setBooks(bookList);
        final Catalog respCatalog = changeBookService.changeBook(catalog);

        catalog.getBooks().get(2).setAuthor(String.format("Author %d", 100));

        changeBookService.changeBook(catalog);
        assertEquals(respCatalog.getBooks().get(2).getAuthor(), String.format("Author %d", 100));
    }
}