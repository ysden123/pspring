/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduledj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Yuriy Stul
 */
@SpringBootApplication(scanBasePackages = {"com.stulsoft.pspring.scheduledj"})
@PropertySource({"classpath:application.properties"})
@Configuration
@Conditional(value = MyCondition.class)
@EnableScheduling
public class Application implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private SomeComponent someComponent;

    @Override
    public void run(String... args) throws Exception {
        logger.info("==>run");

        logger.info("<==run");
    }

    @Scheduled(fixedDelay = 2000)
    public void scheduleFixedDelay() {
        logger.info("==>scheduleFixedDelay");
        someComponent.work();
        logger.info("<==scheduleFixedDelay");
    }
}
