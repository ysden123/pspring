/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.conf.yml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author Yuriy Stul
 */
@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)
@ComponentScan(basePackages = "com.stulsoft.pspring.conf.yml",
        excludeFilters = @ComponentScan.Filter(value = StarterApplication.class, type = FilterType.ANNOTATION))
@ActiveProfiles(profiles = "test")
@TestPropertySource(locations = "classpath:application-test.yml")
public class SomeServiceTest {
    @Autowired
    private SomeService someService;

    @Test
    void showProps() {
        someService.showProps();
    }
}