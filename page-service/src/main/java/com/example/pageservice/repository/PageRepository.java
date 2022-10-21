package com.example.pageservice.repository;

import com.example.pageservice.model.Page;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends MongoRepository<Page, String> {
    List<Page> findPagesByBookTitle(String bookTitle);
//    List<Page> findPagesByItemNames(String ItemName);
    Page findPageByBookTitleAndPageNumber(String bookTitle, int pageNumber);

    Page findPageById(String id);
}
