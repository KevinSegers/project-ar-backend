package com.example.itemservice.controller;


import ch.qos.logback.core.sift.AppenderTracker;
import com.example.itemservice.model.Item;
import com.example.itemervice.repository.ItemRepository;
import org.hibernate.result.UpdateCountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ItemController {

        @Autowired
        private ItemController itemRepository;

        @PostConstruct
        public void fillDB(){
            if(itemRepository.count()==0){
                itemRepository.save(new Item("Nijntje"));
                itemRepository.save(new Item("vader"));
                itemRepository.save(new Item("moeder"));
                itemRepository.save(new Item("auto"));
                itemRepository.save(new Item("schommel"));
                itemRepository.save(new Item("rekstok"));
                itemRepository.save(new Item("ringen"));
                itemRepository.save(new Item("glijbaan"));
                itemRepository.save(new Item("trampoline"));
                itemRepository.save(new Item("klimboom"));
                itemRepository.save(new Item("wip"));
                itemRepository.save(new Item("bessensap"));
            }


        }

        @GetMapping("/books/item/{name}")
        public List<Item> getItemByName(@PathVariable String name){
            return itemRepository.findItemByName(name);
        }

    @PostMapping("/items")
    public Item addItem(@RequestBody Item item){

        itemRepository.save(item);

        return item;
    }




}


