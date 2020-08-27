/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.condition.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author Yuriy Stul
 */
@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@ComponentScan(basePackages = "com.stulsoft.pspring.condition.app",
        excludeFilters = @ComponentScan.Filter(value = Application.class, type = FilterType.ANNOTATION))
public class SomeService1Test {

    @Autowired
    private SomeService1 someService1;

    @Test
    public void test1() {
        System.out.println("In test");
        someService1.test();
    }
}