package com.example.bookservice.repository;

import com.example.bookservice.model.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import ort.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends MongoRePository<Page, String>{
    List<Page> findPagesByBookTitle(String bookTitle);
    List<Page> findPagesByItem(String ItemName);
    Page findPageByPageNumberAndBookTitle(String bookTitle, int pageNumber);
}
