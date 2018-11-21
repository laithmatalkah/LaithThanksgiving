package com.example.LaithThanksgiving.LaithThanksgiving;


import com.example.LaithThanksgiving.LaithThanksgiving.Controllers.CharController;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.CharService;
import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Chars;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharControllerTest {

CharService charServiceMock= Mockito.mock(CharService.class) ;



@Test
    public void createCharTest(){

    Chars expected= new Chars ();
    CharController charController =  new CharController(charServiceMock);

    charController.generateChatracter("Cha1","Warrior",expected);

    verify(charServiceMock, times(1)).createCharacter(expected);

}

}
