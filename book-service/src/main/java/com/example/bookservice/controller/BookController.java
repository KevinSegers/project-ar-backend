package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;

public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void fillDB() {
        if (bookRepository.count() == 0) {


        }
    }

    @GetMapping("/books/item/{name}")
    public Book getItemByName(@PathVariable String name){
        return bookRepository.findBookByTitle(name);
    }

    @PostMapping("/items")
    public Book addItem(@RequestBody Book book){

        bookRepository.save(book);

        return book;
    }


}
