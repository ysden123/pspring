/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Yuriy Stul
 */
@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1_000); // simulated delay

        var timer = new Timer("timer1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendNotification();
            }
        }, 2_000);

        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.name()) + "!");
    }

    private void sendNotification() {
        this.template.convertAndSend("/topic/notification", new Greeting("A notification!"));
    }
}
