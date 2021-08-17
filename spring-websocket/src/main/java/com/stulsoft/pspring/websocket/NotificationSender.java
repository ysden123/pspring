/*
 * Copyright (c) 2021. Webpals
 */

package com.stulsoft.pspring.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Yuriy Stul
 */
@Service
public class NotificationSender {
    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 1_500)
    public void sendNotification(){
        this.template.convertAndSend("/topic/notification", new Greeting("A notification!"));
    }
}
