package com.sparta.test.service;

import com.sparta.test.entity.Item;
import com.sparta.test.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {


    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }


    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

}
