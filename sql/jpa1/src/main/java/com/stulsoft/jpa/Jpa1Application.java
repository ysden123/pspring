/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa;

import com.stulsoft.jpa.soft.Generic;
import com.stulsoft.jpa.soft.ResourceRepository;
import com.stulsoft.jpa.soft.SoftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

@SpringBootApplication
public class Jpa1Application {
    private static final Logger logger = LoggerFactory.getLogger(Jpa1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Jpa1Application.class, args);
    }

    @PersistenceContext
    EntityManager entityManager;

    @Bean
    public CommandLineRunner demo(Table1Repository table1Repository,
                                  Table2Repository table2Repository,
                                  TableAllRepository tableAllRepository,
                                  ResourceRepository resourceRepository,
                                  SoftService softService) {
        return (args -> {
            logger.info("in demo");

/*
            logger.debug("entityManager == null is {}", entityManager == null);

            var query = entityManager.createNativeQuery("select * from generic", Generic.class);
            query.getResultList().forEach(generic -> logger.info("{}", generic));
*/
/*
            table1Repository.findById(1L).ifPresent(table -> logger.info("table: {}", table));

            logger.info("findAll: {}", table1Repository.findAll());
            logger.info("findAll: {}", table2Repository.findAll());

            try {
                logger.info("test1: {}", table1Repository.test1());

                var res = table1Repository.test1();
                res.forEach(o -> logger.info("res o name: {}", o.getClass().getName()));
                logger.info("Stop");
            }catch(Exception exception){
                logger.error(exception.getMessage(), exception);
            }
*/

/*
            logger.info("TableAll:");
            tableAllRepository.findAll().forEach(r -> logger.info("{}", r));

            var names = Arrays.asList("name 2", "name 3");
            logger.info("TableAll by names ({}):", names);
            tableAllRepository.getByNames(names).forEach(r -> logger.info("{}", r));
*/
            softService.showResources();

            softService.showResources(entityManager);
        });
    }
}
