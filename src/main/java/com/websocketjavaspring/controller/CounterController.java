package com.websocketjavaspring.controller;

import com.websocketjavaspring.dto.CounterUpdate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CounterController {

    @MessageMapping("/increment")
    @SendTo("/topic/counter")
    public CounterUpdate counterUpdate() {
        return new CounterUpdate(true);
    }


    //for new connetctions without increment
    @MessageMapping("/getCounter")
    @SendTo("/topic/counter")
    public CounterUpdate getCounter() {
        return new CounterUpdate(false);
    }
}