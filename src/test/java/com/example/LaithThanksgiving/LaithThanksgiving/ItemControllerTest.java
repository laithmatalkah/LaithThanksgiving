package com.example.LaithThanksgiving.LaithThanksgiving;


import com.example.LaithThanksgiving.LaithThanksgiving.Controllers.ItemController;
import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemControllerTest

{

    ItemService itemServiceMock = Mockito.mock(ItemService.class);



    @Test

    public void  addItemTest () throws IOException {

        Item expectedItem= new Item (1L,"Sord");
        ItemController itemController =  new ItemController(itemServiceMock);
        itemController.createItem("Sord",expectedItem);

        verify(itemServiceMock, times(1)).createItem(expectedItem);
    }

    @Test

    public void getItemByNameTest (){

        String name="Sord";

        List<Item> items = new ArrayList<Item>() {{
            add(new Item(1L, "Sord"));
            add(new Item(2L, "Knife"));
            add(new Item(3L, "Rifle"));
            add(new Item(4L, "Rifle"));
        }};
        List<Item> expected=new ArrayList<Item>() {{
            add(new Item(1L, "Sord"));
        }};

        List<Item> actual=new ArrayList<Item>();
        for(int i=0;i<items.size();i++){
            if(items.get(i).getItemName().equals(name)){
                actual.add(items.get(i));
            }
        }
        ItemController itemController=new ItemController(itemServiceMock);
        itemController.getItemByName(name);
        when(itemServiceMock.findItemByName(name)).thenReturn(expected);
        Assert.assertEquals(expected.get(0).getItemName(),actual.get(0).getItemName());


    }

    @Test

    public void getSpecificItemTest(){

        Item expectedItem= new Item (1L,"Sord");

        itemServiceMock.getItem(expectedItem.getItemId());

        ItemController itemController=new ItemController(itemServiceMock);
        itemController.getItem(expectedItem.getItemName(),expectedItem.getItemId());
        verify(itemServiceMock, times(1)).getItem(1L);

    }

    @Test

    public  void deleteItem(){

        ItemController itemController=new ItemController(itemServiceMock);


        verify(itemServiceMock, times(1)).deleteItem(1L);
    }




}
