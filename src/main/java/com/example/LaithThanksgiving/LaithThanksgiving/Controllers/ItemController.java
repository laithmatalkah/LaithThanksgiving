package com.example.LaithThanksgiving.LaithThanksgiving.Controllers;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.ItemService;
import com.rabbitmq.client.RpcClient;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/create/{itemName}")
    public ResponseEntity<Item> createItem(@PathVariable("itemName") String itemName, @RequestBody Item item) {
        item.setItemName(itemName);
        System.out.print("ITEM NAME     " + item.getItemName());
        System.out.print("ITEM SERVIS   " +itemService.findItemByName(item.getItemName()));

//      if (item.getItemId() != null && !itemService.isItemExists(item.getItemId())) {
        if (itemService.findItemByName(item.getItemName())==null) {
            itemService.createItem(item);
            return ResponseEntity.ok(item);
        } else {

            return ResponseEntity.status(409).build(); // object already exists
        }


    }

    @GetMapping("/getall")
    public ResponseEntity<List<Item>> getAllItems (){
        List<Item> items= itemService.getAllItems() ;
        return  ResponseEntity.ok(items);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Item> getItem (@PathVariable ("id") Long id) throws NoSuchElementException {
        try {
            Item item =itemService.getItem(id);
            return  ResponseEntity.ok(item);
        } catch (NoSuchElementException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Item>  deleteItem(@PathVariable("id") Long id)
    {

        if (itemService.isItemExists(id)){
            this.itemService.deleteItem(id);
            return  ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }



}
