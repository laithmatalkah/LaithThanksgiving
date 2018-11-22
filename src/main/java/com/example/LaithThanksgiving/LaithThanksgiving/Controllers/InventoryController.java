package com.example.LaithThanksgiving.LaithThanksgiving.Controllers;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Chars;
import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.CharService;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final ItemService itemService;

    private final CharService charService;

    public InventoryController(ItemService itemService, CharService charService) {
        this.itemService = itemService;
        this.charService = charService;
    }

    @PutMapping("/pickup/{charId}/{itemId}")
    public ResponseEntity <Chars> pickItem (@PathVariable("charId") Long charId,@PathVariable ("itemId") Long itemId,
                                            Chars character,Item item){
        item=itemService.getItem(itemId);
        character=charService.getChar(charId);
        List<Item> inventoryList=character.getInventory();
        inventoryList.add(item);
        character.setInventory(inventoryList);
        charService.updateChar(character);
        return ResponseEntity.ok().body(character);

    }

    @PutMapping("/drop/{charId}/{itemId}")
    public ResponseEntity <Chars> dropItem (@PathVariable("charId") Long charId,@PathVariable ("itemId") Long itemId,
                                            Chars character,Item item){
        item=itemService.getItem(itemId);
        character=charService.getChar(charId);
        List<Item> inventoryList=character.getInventory();
        inventoryList.remove(item);
        character.setInventory(inventoryList);
        charService.updateChar(character);
        return ResponseEntity.ok().body(character);

    }
}
