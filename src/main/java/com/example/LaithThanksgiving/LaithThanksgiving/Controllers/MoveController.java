package com.example.LaithThanksgiving.LaithThanksgiving.Controllers;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Chars;
import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Room;
import com.example.LaithThanksgiving.LaithThanksgiving.data_process_service.ArraySearch;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.CharService;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/move")
public class MoveController {

    private final CharService charService;

    private final RoomService roomService;

    public MoveController(CharService charService, RoomService roomService) {
        this.charService = charService;
        this.roomService = roomService;
    }

    @GetMapping("/{charId}/to/{roomId}")
    public ResponseEntity<Chars> moveChar (@PathVariable("charId") Long charId, @PathVariable("roomId") Long roomId
    , Chars character, Room room){
         character=charService.getChar(charId);
         room=roomService.getRoom(character.getLocation());
         boolean found = ArraySearch.findElement(room.getExits(), roomId);

         if(found){ // Check for exit
             character.setLocation(roomId);
             return ResponseEntity.ok(character);
         }
         else if(!found && character.getHitpoints()>0){
             return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); //  Http 403

         }

         else {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); //  Http 401
         }
    }
}
