package com.example.pagesservice.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Page {

    @Id
    private String id;
    private int pageNumber;
    private List<String> itemNames;
    private String text;
    private Boolean seen;
    private String bookTitle;


    public Page() {
    }


    public Page(String id, int pageNumber, List<String> itemNames, String text, Boolean seen, String bookTitle) {
        this.id = id;
        this.pageNumber = pageNumber;
        this.itemNames = itemNames;
        this.text = text;
        this.seen = seen;
        this.bookTitle = bookTitle;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public void setBookTitle(String bookTitle){this.bookTitle = bookTitle;}

    public String getBookTitle(){return bookTitle;}
}
