/*
 * Copyright (c) 2022, Yuriy Stul
 */

package com.stulsoft.jpa.soft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Arrays;

@Service
public class SoftService {
    private static final Logger logger = LoggerFactory.getLogger(SoftService.class);

    private final ResourceRepository resourceRepository;

    public SoftService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public void showResources(){
        logger.info("In showResources");

        logger.info("All resources:");
        resourceRepository.findAll().forEach(r -> logger.info("{}", r));

        var names = Arrays.asList("resource 2", "resource 3", "resource 4");
        logger.info("Resources by names ({}):", names);
        resourceRepository.findResourcesByNames(names).forEach(r -> logger.info("{}", r));
    }

    public void showResources(EntityManager em){
        logger.info("In showResources(EntityManager em)");
        logger.info("All resources:");
        var query = em.createQuery("select r from Resource r", Resource.class);
        query.getResultList().forEach(r -> logger.info("{}", r));
    }
}
