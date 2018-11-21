package com.example.LaithThanksgiving.LaithThanksgiving.data_service;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Chars;
import com.example.LaithThanksgiving.LaithThanksgiving.repository.CharRepo;
import org.springframework.stereotype.Service;

@Service
public class CharService {

    private final CharRepo charRepo;

    public CharService(CharRepo charRepo) {
        this.charRepo = charRepo;
    }


    public void createCharacter (Chars character){ this.charRepo.save(character);}
}
