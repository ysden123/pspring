/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.condition.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yuriy Stul
 */
@Service
public class SomeService1 {
    private static final Logger logger = LoggerFactory.getLogger(SomeService1.class);

    private final SomeService someService;

    @Autowired
    public SomeService1(final SomeService someService){
        this.someService=someService;
    }

    public void test() {
        logger.info("==>test");
        someService.test();
    }
}
