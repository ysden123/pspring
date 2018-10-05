/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduledj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Yuriy Stul
 */
@Component
public class SomeComponent {
    private static final Logger logger = LoggerFactory.getLogger(SomeComponent.class);

    public void work() {
        logger.info("==>work");
        logger.info("<==work");
    }
}
