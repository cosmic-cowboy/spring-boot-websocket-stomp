package com.slgerkamp.introductory.spring.boot.websocket.stomp.application.controller;

import com.slgerkamp.introductory.spring.boot.websocket.stomp.application.model.Greeting;
import com.slgerkamp.introductory.spring.boot.websocket.stomp.application.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        simpMessagingTemplate.convertAndSend(
                "/topic/greetings",
                "Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
