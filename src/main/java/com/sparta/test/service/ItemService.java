package com.sparta.test.service;

import com.sparta.test.entity.Item;
import com.sparta.test.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {


    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }
}
