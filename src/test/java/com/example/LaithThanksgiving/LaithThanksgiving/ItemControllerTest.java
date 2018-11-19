package com.example.LaithThanksgiving.LaithThanksgiving;


import com.example.LaithThanksgiving.LaithThanksgiving.Controllers.ItemController;
import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.ItemService;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemControllerTest

{

    ItemService itemServiceMock = mock(ItemService.class);
    HttpResponse httpResponseMock = mock(HttpResponse.class);
    HttpClient httpClient = mock(HttpClient.class);
    HttpGet httpGet = mock(HttpGet.class);
    HttpPost httpPost= mock(HttpPost.class);
    HttpResponse httpResponse = mock(HttpResponse.class);
    StatusLine statusLine = mock(StatusLine.class);



    @Test

    public void  addItemTest () throws IOException {

        Item expectedItem= new Item (1L,"Sord");
        ItemController itemController =  new ItemController(itemServiceMock);

        itemController.addItem(expectedItem);

        verify(itemServiceMock, times(1)).addItem(expectedItem);
//        when(statusLine.getStatusCode()).thenReturn(200);
//        when(httpResponse.getStatusLine()).thenReturn(statusLine);
//        when(httpClient.execute(httpPost)).thenReturn(httpResponse);
//
//        //exercise
//        Item actualItem = itemController.addItem(expectedItem);

        //assert
        //assertEquals(actual, expected);


    }

    @Test

    public void getAllItems (){


        List<Item> expected = new ArrayList<Item>() {{
            add(new Item(1L, "Sord"));
            add(new Item(2L, "Knife"));
            add(new Item(3L, "Rifle"));

        }};

        ItemController itemController=new ItemController(itemServiceMock);
        when(itemServiceMock.getAllItems()).thenReturn(expected);
        List<Item> actual= itemController.getAllItems();




    }




}
