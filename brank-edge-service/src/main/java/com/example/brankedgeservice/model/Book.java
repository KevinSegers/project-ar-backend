package com.example.brankedgeservice.model;

public class Book {

    private int id;

    private String title;

    private String author;

    private boolean favorite;

    private boolean available;

    private String coverImageUrl ;

    private String backCoverImageUrl ;

    public Book(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
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
}
