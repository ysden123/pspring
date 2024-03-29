/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.stulsoft.sql.jpa3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private final TestAutoService testAutoService;

    public App(TestAutoService testAutoService) {
        this.testAutoService = testAutoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return (args -> {
            logger.info("==>run");
            test1();
            test2();
        });
    }

    private void test1() {
        logger.info("==>test1");
        Integer count = testAutoService.findCount();
        logger.info("count = {}", count);

        MinMaxTestAuto minMaxTestAuto = testAutoService.findMinMaxNames();
        logger.info("minMaxTestAuto = {}", minMaxTestAuto);

        MinMaxTestAuto minMaxTestAutoWrong = testAutoService.findMinMaxNamesWrong();
        logger.info("minMaxTestAutoWrong = {}", minMaxTestAutoWrong);
    }
    private void test2(){
        logger.info("==>test2");
        testAutoService.findMinMaxNames2();
    }
}
