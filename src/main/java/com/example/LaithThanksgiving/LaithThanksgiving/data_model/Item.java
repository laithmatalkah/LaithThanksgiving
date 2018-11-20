package com.example.LaithThanksgiving.LaithThanksgiving.data_model;



import javax.persistence.*;

@Entity (name= "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name= "ITEM_ID")
    private Long itemId;

    @Column(name="ITEM_NAME")
    private String itemName;

    public Item( ) {

    }

    public Item( String itemName) {
        this.itemName = itemName;
    }

    public Item(Long itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }
}
