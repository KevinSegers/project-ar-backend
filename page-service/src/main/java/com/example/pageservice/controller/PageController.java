package com.example.pageservice.controller;

import com.example.pageservice.model.Page;

import com.example.pageservice.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

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
        Page retrievedPage = pageRepository.findPageById(updatedPage.getId());

        retrievedPage.setPageNumber(updatedPage.getPageNumber());
        retrievedPage.setItemNames(updatedPage.getItemNames());
        retrievedPage.setText(updatedPage.getText());
        retrievedPage.setSeen(updatedPage.isSeen());
        retrievedPage.setBookTitle(updatedPage.getBookTitle());


        pageRepository.save(retrievedPage);

        return retrievedPage;
    }

    @DeleteMapping("/book/page/{pageId}")
    public ResponseEntity deletePage(@PathVariable String pageId) {
        Page page = pageRepository.findPageById(pageId);
        if (page != null) {
            pageRepository.delete(page);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
