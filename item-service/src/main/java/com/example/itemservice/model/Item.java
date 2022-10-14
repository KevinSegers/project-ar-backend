package com.example.itemservice.model;
import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String name;

    private Category category;

    public Item(){}

    public Item(String name, Category category){
        this.name = name;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
