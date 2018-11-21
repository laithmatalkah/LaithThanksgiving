package com.example.LaithThanksgiving.LaithThanksgiving.data_service;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import com.example.LaithThanksgiving.LaithThanksgiving.repository.ItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ItemService {


    private  final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public void createItem (Item item)  {this.itemRepo.save(item);}
    public List<Item> getAllItems () { return (List) itemRepo.findAll();}
    public Item getItem (Long id) { return  itemRepo.findById(id).get();}
    public void updateItem(Item item) { this.itemRepo.save(item);}
    public boolean isItemExists (Long id) { return  itemRepo.existsById(id);}
    public void deleteItem (Long id)  {this.itemRepo.deleteById(id);}
    public List<Item> findItemByName (String name) { return itemRepo.findByName(name);}

}
