package com.example.brankedgeservice.model;

import java.util.List;

public class FilledBook {

    // TODO deze is nu opgesteld zodat het gehele boek in 1 keer wordt opgehaald

    private String bookName;
    private List<Page> pages;
    private List<Book> books;

    public FilledBook() {
    }
    public FilledBook(String bookTitle, List<Page> pages, List<Book> books) {
        this.bookName = bookTitle;
        this.pages = pages;
        this.books = books;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
