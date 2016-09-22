package com.test.catalog.controller;

import com.test.catalog.domain.Catalog;
import com.test.catalog.service.ChangeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by OleksiiPa on 21.09.2016.
 */
@RestController
public class CatalogController {
    @Autowired
    private ChangeBookService changeBookService;

    @RequestMapping(value = "/changeBook",
            method = RequestMethod.POST,
            produces = {"application/xml"},
            consumes = {"application/xml"})
    @ResponseBody
    public Catalog changeBook(@RequestBody Catalog catalog) {
        return changeBookService.changeBook(catalog);
    }
}
