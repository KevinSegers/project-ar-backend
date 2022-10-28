package com.example.bookservice.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String title;

    private String author;

    private Category category;

    private boolean favorite;

    private boolean available;

    private String coverImageUrl ;

    private String backCoverImageUrl ;



    public Book(){}

    public Book( String title, String author, Category category, boolean favorite, boolean available, String coverImageUrl, String backCoverImageUrl) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.favorite = favorite;
        this.available = available;
        this.coverImageUrl = coverImageUrl;
        this.backCoverImageUrl = backCoverImageUrl;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isAvailable() {return available;}

    public void setAvailable(boolean available) { this.available = available;}

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
