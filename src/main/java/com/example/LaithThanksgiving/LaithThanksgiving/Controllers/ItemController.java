package com.example.LaithThanksgiving.LaithThanksgiving.Controllers;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;



    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping ("/add")
    public void addItem (@RequestBody Item item){


        if(!itemService.isItemExists(item.getItemId())){
        itemService.addItem(item);
        } else {

            itemService.updateItem(item);
       }

    }

    @GetMapping("/getall")
    public List<Item> getAllItems (){
        return  itemService.getAllItems();

    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable("id") Long id)
    {
        this.itemService.deleteItem(id);

    }



}
