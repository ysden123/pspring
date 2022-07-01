/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Jpa2Application {
    private static final Logger logger = LoggerFactory.getLogger(Jpa2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Jpa2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(TestVersionRepository testVersionRepository, TestAutoRepository testAutoRepository) {
        return (args -> {
            logger.info("in demo");
//            testForVersioning(testVersionRepository);
//            testForAutoIncrement(testAutoRepository);
            testCount(testAutoRepository);
            testMinMax(testAutoRepository);
        });
    }

    private void testForVersioning(TestVersionRepository testVersionRepository){
/*
            try {
                testVersionRepository.save(new TestVersion("test1", 0));
            }catch(Exception exception){
                logger.error(exception.getMessage(), exception);
            }

            try {
                testVersionRepository.save(new TestVersion("test2", null));
            }catch(Exception exception){
                logger.error(exception.getMessage(), exception);
            }*/

        try{
            var entity = testVersionRepository.findById(1L);
            if (entity.isPresent()){
                var theEntity = entity.get();
                theEntity.setName("test 1 edited 2");
                testVersionRepository.save(theEntity);
            }
        }catch(Exception exception){
            logger.error(exception.getMessage(), exception);
        }

        try{
            var entity = testVersionRepository.findById(2L);
            if (entity.isPresent()){
                var theEntity = entity.get();
                theEntity.setName("test 2 edited");
                theEntity.setVersion(12); // Causes an error: optimistic locking failed; nested exception is org.hibernate.StaleObjectStateException: Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect) : [com.stulsoft.jpa.TestVersion#2]

//                    theEntity.setVersion(null);   // Adds a new row
                testVersionRepository.save(theEntity);
            }
        }catch(Exception exception){
            logger.error(exception.getMessage(), exception);
        }

        try{
            var entity = testVersionRepository.findById(9L);
            if (entity.isPresent()){
                var theEntity = entity.get();
                theEntity.setName("test 3 edited 3");
                testVersionRepository.save(theEntity);
            }
        }catch(Exception exception){
            logger.error(exception.getMessage(), exception);
        }

    }

    private void testForAutoIncrement(TestAutoRepository testAutoRepository){
        logger.info("==>testForAutoIncrement");
        for(int i = 1; i <= 3; ++i){
            var testAuto = new TestAuto("name " + i);
            testAutoRepository.save(testAuto);
        }
    }

    private void testCount(TestAutoRepository testAutoRepository){
        logger.info("==>testCount");
        Integer count = testAutoRepository.findCount();
        logger.info("count={}", count);
    }

    private void testMinMax(TestAutoRepository testAutoRepository){
        logger.info("==>testMinMax");
//        MinMaxTestAuto minMaxTestAuto = testAutoRepository.findMinMaxNames();
//        Object minMaxTestAuto = testAutoRepository.findMinMaxNames();
        String[] minMaxTestAuto = testAutoRepository.findMinMaxNames();
        logger.info("minMaxTestAuto: {}", minMaxTestAuto);
    }
}
