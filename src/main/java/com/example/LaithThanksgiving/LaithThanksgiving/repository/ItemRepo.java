package com.example.LaithThanksgiving.LaithThanksgiving.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Item;

public interface ItemRepo extends CrudRepository <Item, Long> {


}
