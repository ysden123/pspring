/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Yuriy Stul
 */
@Service
public class SomeService {
    private static final Logger logger = LoggerFactory.getLogger(SomeService.class);

    @Scheduled(fixedRate = 1500)
    public void show() {
        logger.info("==>show");
    }
}
