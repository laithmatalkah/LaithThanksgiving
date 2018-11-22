package com.example.LaithThanksgiving.LaithThanksgiving.data_process_service;

public class ArraySearch {

    public static boolean findElement(int[] array , Long element){

        for(int i=0;i<array.length;i++){

            if(element==array[i])
                return true;
        }

        return false;

    }
}
