package com.example.LaithThanksgiving.LaithThanksgiving;


import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Chars;
import com.example.LaithThanksgiving.LaithThanksgiving.data_service.CharService;
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
    charServiceMock.createCharacter(expected);
    verify(charServiceMock, times(1)).createCharacter(expected);


}

}
