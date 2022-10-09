package com.example.itemservice.repository;

import com.example.iteminfoservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository extens jpaRepository<Item, Integer>{
    Item findItemByName(String name);
}
