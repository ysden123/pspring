/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.condition.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

/**
 * @author Yuriy Stul
 */
public class ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("==>main");
        SpringApplication.run(Application.class, args);
        logger.info("<==main");
    }
}
