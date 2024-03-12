package com.example.businessService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.businessService.dto.ItemDTO;
import com.example.businessService.model.Item;
import com.example.businessService.repository.ItemRepository;

@Service("ItemService")
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item create(ItemDTO item) {
        Optional<Item> existItem = itemRepository.findByName(item.getName());
        if (existItem.isEmpty()) {
            Item newItem = new Item();
            newItem.setName(item.getName());
            newItem.setCategory(item.getCategory());
            newItem.setDesciption(item.getDesciption());
            newItem.setLocation(item.getLocation());
            newItem.setExpired(item.getExpired());
            newItem.setQuantity(item.getQuantity());
            itemRepository.save(newItem);
            return newItem;
        } else {
            if (existItem.get().getLocation().equals(item.getLocation())) {
                existItem.get().setQuantity(existItem.get().getQuantity() + item.getQuantity());
                itemRepository.save(existItem.get());
                return existItem.get();
            } else {
                Item newItem = new Item();
                newItem.setName(item.getName());
                newItem.setCategory(item.getCategory());
                newItem.setDesciption(item.getDesciption());
                newItem.setLocation(item.getLocation());
                newItem.setExpired(item.getExpired());
                newItem.setQuantity(item.getQuantity());
                itemRepository.save(newItem);
                return newItem;
            }
        }
    }

    public Item edit(ItemDTO item) {
        Optional<Item> existItem = itemRepository.findByNameAndLocation(item.getName(), item.getLocation());
        existItem.get().setName(item.getName());
        existItem.get().setCategory(item.getCategory());
        existItem.get().setDesciption(item.getDesciption());
        existItem.get().setLocation(item.getLocation());
        existItem.get().setExpired(item.getExpired());
        existItem.get().setQuantity(item.getQuantity());
        itemRepository.save(existItem.get());
        return existItem.get();
    }

}
