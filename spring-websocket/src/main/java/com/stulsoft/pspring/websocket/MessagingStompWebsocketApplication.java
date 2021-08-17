/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Yuriy Stul
 */
@SpringBootApplication
@EnableScheduling
public class MessagingStompWebsocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessagingStompWebsocketApplication.class, args);
    }
}
