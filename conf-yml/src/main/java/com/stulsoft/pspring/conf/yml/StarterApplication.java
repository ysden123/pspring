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
import org.springframework.core.env.Environment;

import java.util.Scanner;

@SpringBootApplication
public class StarterApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(StarterApplication.class);

    private final SomeService someService;
    private final Environment env;

    @Autowired
    public StarterApplication(final SomeService someService, final Environment env) {
        this.someService = someService;
        this.env = env;
    }

    public static void main(String[] args) {
        logger.info("==>main");
        System.out.println("Choose environment:");
        System.out.println("0 - default");
        System.out.println("1 - dev");
        System.out.println("2 - prod");
        var choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
                break;
            case 2:
                System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
                break;
            default:
                System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "default");
                break;
        }
        SpringApplication.run(StarterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("==>run");

        var p = env.getActiveProfiles();
        if (!(p.length > 0 && "test".equals(p[0]))){
            someService.showProps();
        }
    }
}
