/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.spring.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Yuriy Stul
 */
@Order(value = 1)
@Component
public class AppApplicationRunner implements ApplicationRunner {

    private final Component2 component2;

    public AppApplicationRunner(Component2 component2) {
        this.component2 = component2;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==>AppApplicationRunner::run");
        component2.func2();
    }
}
