package com.example.LaithThanksgiving.LaithThanksgiving.Controllers;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Room;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/room")
public class RoomController {


    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity <Room>  createRoom (@RequestBody Room room){

        roomService.createRoom(room);
        return ResponseEntity.ok(room);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity <Room> getRoomById(@PathVariable ("id") Long id){

        try {
            Room room = roomService.getRoom(id);
            return ResponseEntity.ok(room);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



}
