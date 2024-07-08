package com.sparta.test.controller;

import com.sparta.test.entity.Item;
import com.sparta.test.repository.ItemRepository;
import com.sparta.test.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ItemController {

    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemService itemService, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/post")
    public String itemList(Model model) {
        // 모든 아이템을 조회하여 리스트 페이지로 전달
        model.addAttribute("items", itemService.getAllItems());
        return "list";
    }

    @GetMapping("/write")
    public String itemForm() {
        return "write";
    }

    @PostMapping("/post")
    public String createItem(String title, String content, Integer price, String username) {

        Item item = new Item();
        item.setTitle(title);
        item.setContent(content);
        item.setPrice(price);
        item.setUsername(username);

        itemService.saveItem(item);

        return "redirect:/post";
    }

    @GetMapping("/post/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Item> optionalItem = itemService.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            model.addAttribute("item", item);
            return "edit";
        } else {
            return "redirect:/post";
        }
    }

    @PostMapping("/edit")
    public String updateItem(@RequestParam Long id,
                             @RequestParam String title,
                             @RequestParam String content,
                             @RequestParam Integer price, @RequestParam String username) {
        Optional<Item> optionalItem = itemService.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setTitle(title);
            item.setContent(content);
            item.setPrice(price);
            item.setUsername(username);
            itemService.saveItem(item);
        }
        return "redirect:/post";
    }

    @DeleteMapping("/post/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/post";
    }


}
