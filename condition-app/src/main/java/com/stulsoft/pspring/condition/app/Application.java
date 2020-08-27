/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.condition.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yuriy Stul
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private final SomeService someService;
    private final SomeService1 someService1;

    @Autowired
    public Application(
            final SomeService someService,
            final SomeService1 someService1) {
        this.someService = someService;
        this.someService1 = someService1;
    }

    @Override
    public void run(String... args) {
        logger.info("==>run");
        someService.test();
        someService1.test();
    }
}
