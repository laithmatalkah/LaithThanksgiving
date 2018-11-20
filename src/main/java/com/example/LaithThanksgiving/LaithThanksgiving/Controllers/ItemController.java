package com.example.LaithThanksgiving.LaithThanksgiving.Controllers;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.ItemService;
import com.rabbitmq.client.RpcClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;



    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping ("/item")
    public ResponseEntity<Item> addItem (@RequestBody Item item) throws URISyntaxException

    {
            if (item.getItemId() != null && !itemService.isItemExists(item.getItemId())) {
                itemService.addItem(item);
                return  ResponseEntity.status(HttpStatus.OK).build();
            } else {

                itemService.updateItem(item);
                return  ResponseEntity.status(HttpStatus.OK).build();
            }
    }

    @GetMapping("/getall")
    public List<Item> getAllItems (){
        return  itemService.getAllItems();

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
