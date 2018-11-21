package com.example.LaithThanksgiving.LaithThanksgiving.data_service;

import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Room;
import com.example.LaithThanksgiving.LaithThanksgiving.repository.RoomRepo;
import org.springframework.stereotype.Service;


@Service
public class RoomService {


    private final RoomRepo roomRepo;

    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public void createRoom (Room room){ this.roomRepo.save(room);}
    public Room getRoom (Long id) { return this.roomRepo.findById(id).get();}


}
