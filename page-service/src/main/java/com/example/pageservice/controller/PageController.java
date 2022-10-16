package com.example.pageservice.controller;

import com.example.pageservice.model.Page;

import com.example.pageservice.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PageController {

    @Autowired
    private PageRepository pageRepository;

    @PostConstruct
    public void fillDB(){
        if(pageRepository.count() == 0){

            List<String> itemsPageOne = new ArrayList<>(Arrays.asList("nijntje", "mama nijntje", "papa nijntje"));
            List<String> itemsPageTwo = new ArrayList<>(Arrays.asList("nijntje", "mama nijntje", "papa nijntje", "auto"));
            List<String> itemsPageThree = new ArrayList<>(Arrays.asList("nijntje", "mama nijntje", "papa nijntje"));
            List<String> itemsPageFour = new ArrayList<>(Arrays.asList("nijntje", "schommel"));
            List<String> itemsPageFive = new ArrayList<>(Arrays.asList("nijntje", "ringen"));
            List<String> itemsPageSix = new ArrayList<>(Arrays.asList("nijntje", "rekstok"));
            List<String> itemsPageSeven = new ArrayList<>(Arrays.asList("nijntje", "klimboom"));
            List<String> itemsPageEight = new ArrayList<>(Arrays.asList("nijntje", "glijbaan"));
            List<String> itemsPageNine = new ArrayList<>(Arrays.asList("nijntje", "wip"));
            List<String> itemsPageTen = new ArrayList<>(Arrays.asList("nijntje", "trampoline"));
            List<String> itemsPageEleven = new ArrayList<>(Arrays.asList("nijntje", "mama nijntje", "papa nijntje", "bessensap"));
            List<String> itemsPageTwelve = new ArrayList<>(Arrays.asList("nijntje", "mama nijntje", "papa nijntje", "auto"));

            pageRepository.save(new Page(1, itemsPageOne, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(2, itemsPageTwo, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(3, itemsPageThree, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(4, itemsPageFour, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(5, itemsPageFive, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(6, itemsPageSix, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(7, itemsPageSeven, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(8, itemsPageEight, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(9, itemsPageNine, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(10, itemsPageTen, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(11, itemsPageEleven, false, "Nijntje in de speeltuin"));
            pageRepository.save(new Page(12, itemsPageTwelve, false, "Nijntje in de speeltuin"));

        }
    }

    @GetMapping("/pages/{bookTitle}")
    public List<Page> getPageByBookTitle(@RequestBody String bookTitle){

        return pageRepository.findPagesByBookTitle(bookTitle);

    }

    @GetMapping("/pages/{bookTitle}/pagenumber/{pagenumber}")
    public Page getPageByBookTitleAndPagenumber(@RequestBody String bookTitle, @RequestBody int pagenumber){

        return pageRepository.findPageByBookTitleAndPagenumber(bookTitle, pagenumber);

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
