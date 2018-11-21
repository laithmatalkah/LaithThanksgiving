package com.example.LaithThanksgiving.LaithThanksgiving.data_model;


import javax.persistence.*;

@Entity(name="ROOMS")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="ROOM_ID")
    private Long roomId;

    @Column (name="ROOM_DESCRIPTION")
    private String description;

    @Column (name="EXITS")
    private int[] exits;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getExits() {
        return exits;
    }

    public void setExits(int[] exits) {
        this.exits = exits;
    }
}
