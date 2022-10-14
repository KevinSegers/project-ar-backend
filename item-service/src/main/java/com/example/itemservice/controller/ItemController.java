package com.example.itemservice.controller;


import ch.qos.logback.core.sift.AppenderTracker;
import com.example.itemservice.model.Category;
import com.example.itemservice.model.Item;
import com.example.itemservice.repository.ItemRepository;
import org.hibernate.result.UpdateCountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
public class ItemController {

        @Autowired
        private ItemRepository itemRepository;

        @PostConstruct
        public void fillDB(){
            if(itemRepository.count()==0){
                itemRepository.save(new Item("Nijntje", Category.PERSON));
                itemRepository.save(new Item("vader", Category.PERSON));
                itemRepository.save(new Item("moeder", Category.PERSON));
                itemRepository.save(new Item("auto", Category.TRANSPORT));
                itemRepository.save(new Item("schommel", Category.PLAYGROUND));
                itemRepository.save(new Item("rekstok",  Category.PLAYGROUND));
                itemRepository.save(new Item("ringen",  Category.PLAYGROUND));
                itemRepository.save(new Item("glijbaan",  Category.PLAYGROUND));
                itemRepository.save(new Item("trampoline",  Category.PLAYGROUND));
                itemRepository.save(new Item("klimboom",  Category.PLAYGROUND));
                itemRepository.save(new Item("wip",  Category.PLAYGROUND));
                itemRepository.save(new Item("bessensap",  Category.FOOD));
            }


        }

        @GetMapping("/books/item/{name}")
        public Item getItemByName(@PathVariable String name){
            return itemRepository.findItemByName(name);
        }

    @PostMapping("/items")
    public Item addItem(@RequestBody Item item){

        itemRepository.save(item);

        return item;
    }




}


