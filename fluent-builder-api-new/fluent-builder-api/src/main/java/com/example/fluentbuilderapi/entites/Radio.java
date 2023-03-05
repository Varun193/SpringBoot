package com.example.fluentbuilderapi.entites;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Radio {

    @Value("${frequency}")
    String frequency;

    public void listen(){
        System.out.println("frequency is "+ frequency );
    }

}
