package com.example.brankedgeservice.model;

import java.util.List;

public class Book {

    // TODO deze is nu opgesteld zodat het gehele boek in 1 keer wordt opgehaald

    private String bookName;
    private List<Page> pages;
    private List<Item> items;

    public Book() {
    }
    public Book (String bookTitle, List<Page> pages, List<Item> items) {
        this.bookName = bookTitle;
        this.pages = pages;
        this.items = items;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
