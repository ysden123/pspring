/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.conf.yml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author Yuriy Stul
 */
@Service
public class SomeService {
    private static final Logger logger = LoggerFactory.getLogger(SomeService.class);
    private final Environment env;

    @Autowired
    public SomeService(final Environment env) {
        this.env = env;
    }

    public void showProps() {
        logger.info("t1.t11: {}", env.getRequiredProperty("t1.t11"));
        logger.info("t2.t21: {}", env.getRequiredProperty("t2.t21"));
        logger.info("o1: {}", env.getRequiredProperty("o1"));
        var port = env.getProperty("port", Integer.class);
        logger.info("port={}",port);
    }
}
