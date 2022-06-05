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
    public CommandLineRunner runner(DomainSourceMappingRepository domainSourceMappingRepository,
                                    SourceFileRepository sourceFileRepository,
                                    SourceLibraryRepository sourceLibraryRepository,
                                    SomeService someService) {
        return (args -> {
            logger.info("In runner");

            // clear all
            domainSourceMappingRepository.deleteAll();
            sourceFileRepository.deleteAll();
            sourceLibraryRepository.deleteAll();

            // fill data
            SourceFile sourceFile_1 = new SourceFile("file 1", "sha1 1");
            SourceFile sourceFile_2 = new SourceFile("file 2", "sha1 2");
            SourceFile sourceFile_3 = new SourceFile("file 3", "sha1 3");
            SourceFile sourceFile_4 = new SourceFile("file 4", "sha1 4");
            SourceFile sourceFile_5 = new SourceFile("file 5", null);
            SourceFile sourceFile_6 = new SourceFile(null, "sha1 6");
            SourceFile sourceFile_7 = new SourceFile("file 7", "sha1 4");   // same sha1 for dif files
            sourceFileRepository.saveAll(Arrays.asList(sourceFile_1,
                    sourceFile_2,
                    sourceFile_3,
                    sourceFile_4,
                    sourceFile_5,
                    sourceFile_6,
                    sourceFile_7
            ));

            SourceLibrary sourceLibrary_1 = new SourceLibrary("lib 1");
            SourceLibrary sourceLibrary_2 = new SourceLibrary("lib 2");
            SourceLibrary sourceLibrary_3 = new SourceLibrary("lib 3");
            SourceLibrary sourceLibrary_4 = new SourceLibrary("lib 4");
            sourceLibraryRepository.saveAll(Arrays.asList(
                    sourceLibrary_1,
                    sourceLibrary_2,
                    sourceLibrary_3,
                    sourceLibrary_4
            ));

            DomainSourceMapping domainSourceMapping = new DomainSourceMapping(sourceFile_1, sourceLibrary_1);
            domainSourceMappingRepository.save(domainSourceMapping);

            domainSourceMapping = new DomainSourceMapping(sourceFile_1, sourceLibrary_2);
            domainSourceMappingRepository.save(domainSourceMapping);

            domainSourceMapping = new DomainSourceMapping(sourceFile_2, sourceLibrary_2);
            domainSourceMappingRepository.save(domainSourceMapping);

            domainSourceMapping = new DomainSourceMapping(sourceFile_3, null);
            domainSourceMappingRepository.save(domainSourceMapping);

            domainSourceMapping = new DomainSourceMapping(sourceFile_3, sourceLibrary_3);
            domainSourceMappingRepository.save(domainSourceMapping);

            domainSourceMapping = new DomainSourceMapping(null, null);
            domainSourceMappingRepository.save(domainSourceMapping);

            domainSourceMapping = new DomainSourceMapping(null, sourceLibrary_3);
            domainSourceMappingRepository.save(domainSourceMapping);

            domainSourceMapping = new DomainSourceMapping(sourceFile_4, sourceLibrary_4);
            domainSourceMappingRepository.save(domainSourceMapping);
            domainSourceMapping = new DomainSourceMapping(sourceFile_7, sourceLibrary_4);
            domainSourceMappingRepository.save(domainSourceMapping);

            try {
                Map<String, Collection<SourceLibrary>> searchResult = someService
                        .findSourceLibraries(Arrays.asList(
                                "sha1 1",
                                "sha1 2",
                                "sha1 3",
                                "sha1 4",
                                "sha1 non exist",
                                null,
                                "sha1 6",
                                ""));
                logger.info("searchResult: {}", searchResult);

/*
                searchResult = someService
                        .findSourceLibraries(Collections.EMPTY_LIST);
                logger.info("searchResult: {}", searchResult);
*/
/*
                searchResult = someService
                        .findSourceLibraries(null);
                logger.info("searchResult: {}", searchResult);
*/
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
