package com.stulsoft.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("==>main");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(ContainerRepository containerRepository,
                                    NestedRepository nestedRepository,
                                    Nested2Repository nested2Repository,
                                    SomeService someService) {
        return (args -> {
            logger.info("In runner");

/*
            // clear all
            containerRepository.deleteAll();
            nestedRepository.deleteAll();
            nested2Repository.deleteAll();

            // fill data

            Nested nested = new Nested("nested 1", 123);
            nestedRepository.save(nested);

            Nested2 nested2_1 = new Nested2("kind 1");
            Nested2 nested2_2 = new Nested2("kind 2");
            nested2Repository.saveAll(Arrays.asList(nested2_1, nested2_2));

            Container container = new Container("type 1", nested, nested2_1);
            containerRepository.save(container);

            container = new Container("type 2", nested, nested2_2);
            containerRepository.save(container);

*/

/*
            containerRepository.findAll().forEach(container -> {
                logger.info("{}", container);
            });
*/

            try {
                Map<String, Collection<Nested2>> searchResult = someService.findNested2(Arrays.asList("type 1","type 2"));
                logger.info("searchResult: {}", searchResult);
/*
                {
                    Nested nested = new Nested("nested 1", 123);
                    nestedRepository.save(nested);
                    Container container = new Container("type 1", nested);
                    containerRepository.save(container);
                }
*/
/*
                {
                    Nested nested = new Nested("nested 2", 456);
                    nestedRepository.save(nested);
                    Nested2 nested2 = new Nested2("kind 1");
                    nested2Repository.save(nested2);
                    Container container = new Container("type 2", nested, nested2);
                    containerRepository.save(container);
                }
*/

/*
                {
                    containerRepository.findAll().forEach(container -> logger.info("{}", container));
                }

                {
                    List result = containerRepository.findSpecial(Collections.singletonList("type 1"));
                    logger.info("result.size()={}", result.size());

                    for (Object row : result) {
                        logger.info("row class is {}", row.getClass().getName());
                    }
                }

                {
                    List result = containerRepository.findSpecial(Collections.singletonList("type 2"));
                    logger.info("result.size()={}", result.size());

                    for (Object row : result) {
                        logger.info("row:");
                        Object[] objects = (Object[]) row;
                        for (Object object : objects) {
                            logger.info("   {}", object);
                        }
                    }

                    Map<String, Collection<Nested2>> searchResult = someService.findNested2(Collections.singletonList("type 2"));
                    logger.info("searchResult: {}", searchResult);

                }
                 */
            } catch (Exception exception) {
                logger.error(exception.getMessage(), exception);
            }
        });
    }
}
