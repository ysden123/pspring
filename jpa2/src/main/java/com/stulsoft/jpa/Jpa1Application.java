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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class Jpa1Application {
    private static final Logger logger = LoggerFactory.getLogger(Jpa1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Jpa1Application.class, args);
    }

    @PersistenceContext
    EntityManager entityManager;

    @Bean
    public CommandLineRunner demo(TestVersionRepository testVersionRepository) {
        return (args -> {
            logger.info("in demo");
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
                if (!entity.isEmpty()){
                    var theEntity = entity.get();
                    theEntity.setName("test 1 edited 2");
                    testVersionRepository.save(theEntity);
                }
            }catch(Exception exception){
                logger.error(exception.getMessage(), exception);
            }

            try{
                var entity = testVersionRepository.findById(2L);
                if (!entity.isEmpty()){
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
                if (!entity.isEmpty()){
                    var theEntity = entity.get();
                    theEntity.setName("test 3 edited 3");
                    testVersionRepository.save(theEntity);
                }
            }catch(Exception exception){
                logger.error(exception.getMessage(), exception);
            }
        });
    }
}
