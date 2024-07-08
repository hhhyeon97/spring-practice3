package com.sparta.test.controller;

import com.sparta.test.entity.Item;
import com.sparta.test.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/post")
    public String itemList(){
        return "list";
    }

    @GetMapping("/write")
    public String itemForm(){
        return "write";
    }

    @PostMapping("/post")
    public  String createItem(@RequestParam String title,
                              @RequestParam String content,
                              @RequestParam Integer price,@RequestParam String username) {

        Item item = new Item();
        item.setTitle(title);
        item.setContent(content);
        item.setPrice(price);
        item.setUsername(username);

        itemService.saveItem(item);

        return "redirect:/post";
    }

    @PutMapping("/post/{id}")
    public  String updateItem(@PathVariable int id){
        return "list";
    }

    @DeleteMapping("/post/{id}")
    public  String deleteItem(@PathVariable int id){
        return "list";
    }


}
