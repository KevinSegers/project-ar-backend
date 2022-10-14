package com.example.brankedgeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${pageservice.baseurl}")
    private String pageServiceBaseUrl;

    @Value("${bookservice.baseurl}")
    private String bookServiceBaseUrl;
}
