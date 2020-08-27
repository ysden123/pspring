/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.condition.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Yuriy Stul
 */
@Service
public class SomeService {
    private static final Logger logger = LoggerFactory.getLogger(SomeService.class);

    public void test() {
        logger.info("==>test");
    }
}
