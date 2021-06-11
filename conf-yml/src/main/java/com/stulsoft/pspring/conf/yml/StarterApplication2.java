/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.conf.yml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

//@SpringBootApplication
public class StarterApplication2 implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(StarterApplication2.class);

    private final SomeService someService;

    @Autowired
    public StarterApplication2(final SomeService someService) {
        this.someService = someService;
    }

    public static void main(String[] args) {
        logger.info("==>main");
        if (System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME) == null){
            System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        }
        logger.debug("Active profiles: {}", System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME));
        SpringApplication.run(StarterApplication2.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("==>run");
        someService.showProps();
    }
}
