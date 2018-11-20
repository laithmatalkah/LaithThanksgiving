package com.example.LaithThanksgiving.LaithThanksgiving.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;

public interface ItemRepo extends CrudRepository<Item, Long> {

    @Query("select i from ITEMS i where i.itemName=?1")

    Item findByName(String name);


}
