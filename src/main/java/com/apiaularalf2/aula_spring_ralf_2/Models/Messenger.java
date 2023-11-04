package com.apiaularalf2.aula_spring_ralf_2.Models;

import org.springframework.stereotype.Component;
@Component
public class Messenger {
    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    private String messenger;
}
