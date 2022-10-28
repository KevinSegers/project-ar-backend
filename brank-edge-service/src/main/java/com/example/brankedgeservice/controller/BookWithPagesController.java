package com.example.brankedgeservice.controller;

import com.example.brankedgeservice.model.*;
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

    @GetMapping("/interactivebooks/category/{category}")
    public List<BookWithPages> getBooksByCategory(@PathVariable Category category){
        List<BookWithPages> returnList = new ArrayList<>();


        ResponseEntity<List<Book>> responseEntityBooks =
                restTemplate.exchange("http://" + bookServiceBaseUrl + "/books/category/" + category,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                        });

        List<Book> books = responseEntityBooks.getBody();


        for (Book book: books) {
            String bookTitle = book.getTitle();
           List<Page> pages =
                    restTemplate.exchange("http://" + pageServiceBaseUrl + "/pages/bookTitle/" + bookTitle, HttpMethod.GET, null, new ParameterizedTypeReference<List<Page>>() {
                            }).getBody();

            returnList.add(new BookWithPages(book, pages));

        }

        return returnList;

    }

    @GetMapping("/interactivebooks/book/{bookTitle}/page/{pageNumber}")
    public Page getPageByBooktitleAndPagenumber(@PathVariable String bookTitle, @PathVariable int pageNumber){
        Page page = restTemplate.getForObject("http://"+pageServiceBaseUrl+"/pages/bookTitle/"+bookTitle+"/pageNumber/"+pageNumber, Page.class );
        return page;
    }


}
