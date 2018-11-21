package com.example.LaithThanksgiving.LaithThanksgiving.Controllers;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Chars;
import com.example.LaithThanksgiving.LaithThanksgiving.data_process_service.RandomGenerator;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.CharService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharController {

    private final CharService charService;

    public CharController(CharService charService) {
        this.charService = charService;
    }

    @PostMapping ("/gen/{charName}/{charClass}")

    public ResponseEntity<Chars> generateChatracter (@PathVariable ("charName") String charName, @PathVariable("charClass") String charClass
    , @RequestBody Chars character) {

        character.setName(charName);
        character.setCharClass(charClass);
        RandomGenerator.generateRandoms(character);
        charService.createCharacter(character);
        return ResponseEntity.ok(character);

    }


    }

