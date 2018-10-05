/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pspring.scheduledj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Yuriy Stul
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = "app.scheduling.enable=false")
@SpringBootTest
@ComponentScan(basePackages = "com.stulsoft.pspring.scheduledj")
public class SomeComponentTest {

    @Autowired
    private SomeComponent someComponent;

    @Test
    public void work() {
        someComponent.work();
    }
}