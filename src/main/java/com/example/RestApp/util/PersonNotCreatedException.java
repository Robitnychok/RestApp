package com.example.RestApp.util;

public class PersonNotCreatedException extends RuntimeException {

    public PersonNotCreatedException(String msg){
        super(msg);
    }

}
