package com.example.LaithThanksgiving.LaithThanksgiving.data_process_service;

import com.example.LaithThanksgiving.LaithThanksgiving.data_model.Chars;

import java.util.Arrays;

// Generate all randoms for the Character
public class RandomGenerator {



    public static void generateRandoms (Chars character) {

        int [] randomList=new int[5];
        for(int i=0;i<randomList.length;i++){

            randomList[i]=(int) (Math.random()* (17-9)+1) +9;

        }

        //get Min,Max by sorting
        Arrays.sort(randomList);
        int min= randomList[0];
        int max=randomList[4];

        switch (character.getCharClass().toLowerCase()){

            case "warrior":
                character.setStr(max);
                character.setInt(min);
                character.setWis((int) (Math.random()* (max-min)+1) +min);
                character.setCha((int) (Math.random()* (max-min)+1) +min);
                character.setDex((int) (Math.random()* (max-min)+1) +min);
                break;

            case  "archer" :
                character.setDex(max);
                character.setCha(min);
                character.setWis((int) (Math.random()* (max-min)+1) +min);
                character.setStr((int) (Math.random()* (max-min)+1) +min);
                character.setInt((int) (Math.random()* (max-min)+1) +min);
                break;

            case "wizard" :
                character.setInt(max);
                character.setStr(min);
                character.setWis((int) (Math.random()* (max-min)+1) +min);
                character.setDex((int) (Math.random()* (max-min)+1) +min);
                character.setCha((int) (Math.random()* (max-min)+1) +min);
                break;

            case "rogue":
                character. setCha(max);
                character.setStr(min);
                character.setDex((int) (Math.random()* (max-min)+1) +min);
                character.setWis((int) (Math.random()* (max-min)+1) +min);
                character.setInt((int) (Math.random()* (max-min)+1) +min);
                break;

            default: throw  new IllegalArgumentException ("Class Name is Wrong");
        }



        character.setLocation(3L);//(int) (Math.random()* (18-8)+1) +8);
        character.setCon((int) (Math.random()* (18-8)+1) +8);
        character.setHitpoints(character.getCon()*2);

    }


}
