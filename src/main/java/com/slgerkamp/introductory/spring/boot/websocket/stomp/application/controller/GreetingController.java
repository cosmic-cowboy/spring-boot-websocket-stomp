package com.slgerkamp.introductory.spring.boot.websocket.stomp.application.controller;

import com.slgerkamp.introductory.spring.boot.websocket.stomp.application.model.Greeting;
import com.slgerkamp.introductory.spring.boot.websocket.stomp.application.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/hello")
    @ResponseStatus(HttpStatus.CREATED)
    public void greeting(@RequestBody HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        simpMessagingTemplate.convertAndSend(
                "/topic/greetings",
                "Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
