package com.example.LaithThanksgiving.LaithThanksgiving.data_service;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import com.example.LaithThanksgiving.LaithThanksgiving.repository.ItemRepo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service

public class ItemService {


    private  final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public void addItem(Item item)  {this.itemRepo.save(item);}
    public List<Item> getAllItems () { return (List) itemRepo.findAll();}
}
