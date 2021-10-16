/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.spring.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Yuriy Stul
 */
@Order(value = 2)
@Component
public class AppCommandLineRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("==>AppCommandLineRunner2::run");
    }
}
