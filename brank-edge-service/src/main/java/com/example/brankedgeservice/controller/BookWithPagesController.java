package com.example.brankedgeservice.controller;

import com.example.brankedgeservice.model.Book;
import com.example.brankedgeservice.model.BookWithPages;
import com.example.brankedgeservice.model.Category;
import com.example.brankedgeservice.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookWithPagesController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${pageservice.baseurl}")
    private String pageServiceBaseUrl;

    @Value("${bookservice.baseurl}")
    private String bookServiceBaseUrl;

    @GetMapping("/books/category/{category}")
    public List<BookWithPages> getBooksByCategory(@PathVariable Category category){
        List<BookWithPages> returnList = new ArrayList<>();


        ResponseEntity<List<Book>> responseEntityBooks =
                restTemplate.exchange("http://" + bookServiceBaseUrl + "/books/category/{category}",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                        }, category);

        List<Book> books = responseEntityBooks.getBody();


        for (Book book: books) {
           List<Page> pages =
                    restTemplate.exchange("http://" + pageServiceBaseUrl + "pages/{bookTitle}", HttpMethod.GET, null, new ParameterizedTypeReference<List<Page>>() {
                            }, book.getTitle()).getBody();

           returnList.add(new BookWithPages(book, pages));

        }

        return returnList;

    }

    @GetMapping("/pages/book/{bookTitle}/page/{pagenumber}")
    public Page getPageByBooktitleAndPagenumber(@PathVariable String bookTitle, @PathVariable int pagenumber){
        Page page = restTemplate.getForObject("http://"+pageServiceBaseUrl+"/pages/"+bookTitle+"/pagenumber/"+pagenumber, Page.class );
        return page;
    }


}
