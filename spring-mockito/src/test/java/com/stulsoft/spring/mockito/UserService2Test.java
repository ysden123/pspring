/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.spring.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Yuriy Stul
 * @see <a href="http://www.baeldung.com/injecting-mocks-in-spring">Injecting Mockito Mocks into Spring Beans</a>
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MocksApplication.class)
public class UserService2Test {

    @Autowired
    private UserService userService;

    @Autowired
    private NameService nameService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(nameService.getUserName("SomeId")).thenReturn("Mock user name 2");
        String testName = userService.getUserName("SomeId");
        assertEquals("Mock user name 2", testName);
    }
}