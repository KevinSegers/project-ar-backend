package com.example.bookservice.controller;

import com.example.bookservice.model.Page;

import com.example.bookservice.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class PageController {

    @Autowired
    private PageRepository pageRepository;

    @PostConstruct
    public void fillDB(){
        if(pageRepository.count() == 0){

        }
    }


    @PostMapping("/pages")
    public Page addPage(@RequestBody Page page){

        pageRepository.save(page);

        return page;
    }

    @PutMapping("/pages")
    public Page updatePage(@RequestBody Page updatedPage){
        Page retrievedPage = pageRepository.findPageByPageId(updatedPage.getPageId());

        retrievedPage.setPageNumber(updatedPage.getISBN());
        retrievedPage.setItemNames(updatedPage.getItemNames());
        retrievedPage.setText(updatedPage.getText());
        retrievedPage.setSeen(updatedPage.isSeen());
        retrievedPage.setBookTitle(updatedPage.getBookTitle());




        pageRepository.save(retrievedPage);

        return retrievedPage;
    }

    @DeleteMapping("/book/page/{pageId}")
    public ResponseEntity deletePage(@PathVariable Integer pageId){
        Page page = pageRepository.findPageByPageId(pageId);
        if(page!=null){
            pageRepository.delete(page);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }


}
