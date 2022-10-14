package com.example.itemservice.repository;

import com.example.itemservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
    Item findItemByName(String name);
}
