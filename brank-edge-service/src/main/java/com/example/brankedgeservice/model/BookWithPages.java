package com.example.brankedgeservice.model;

import java.util.ArrayList;
import java.util.List;

public class BookWithPages {

    private String bookTitle;

    private String author;

    private boolean favorite;

    private boolean available;

    private String coverImageUrl ;

    private String backCoverImageUrl ;
    private List<Page> pagesFromBook;


    public BookWithPages(Book book, List<Page> pages) {
        setBookTitle(book.getTitle());
        setAuthor(book.getAuthor());
        setFavorite(book.isFavorite());
        setCoverImageUrl(book.getCoverImageUrl());
        setBackCoverImageUrl(book.getBackCoverImageUrl());
        pagesFromBook = new ArrayList<>();
//        pages.forEach(page ->{
//            if (book.getTitle() == page.getBookTitle()) {
//                pagesFromBook.add(page);
//            }});
        setPagesFromBook(pages);

    }

    public BookWithPages(Book book, Page page) {
        setBookTitle(book.getTitle());
        setAuthor(book.getAuthor());
        setFavorite(book.isFavorite());
        setAvailable(book.isAvailable());
        setCoverImageUrl(book.getCoverImageUrl());
        setBackCoverImageUrl(book.getBackCoverImageUrl());
        pagesFromBook = new ArrayList<>();
        pagesFromBook.add(page);
        setPagesFromBook(pagesFromBook);

    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getBackCoverImageUrl() {
        return backCoverImageUrl;
    }

    public void setBackCoverImageUrl(String backCoverImageUrl) {
        this.backCoverImageUrl = backCoverImageUrl;
    }

    public List<Page> getPagesFromBook() {
        return pagesFromBook;
    }

    public void setPagesFromBook(List<Page> pagesFromBook) {
        this.pagesFromBook = pagesFromBook;
    }
}
