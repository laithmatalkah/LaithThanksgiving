package com.example.LaithThanksgiving.LaithThanksgiving.repository;

import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<Item, Long> {


  @Query("select i from ITEMS i where i.itemName=?1") // search object by name

  List<Item> findByName(String name);


}
