/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.conf.yml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Yuriy Stul
 */
@SpringBootTest
@ActiveProfiles(profiles = "test")
class SomeServiceTest {
    @Autowired
    private SomeService someService;

    @Test
    void showProps() {
        someService.showProps();
    }
}