/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.restapi.controllers;

import com.stulsoft.pspring.restapi.data.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuriy Stul
 */
@RestController
public class SomeServiceController {
    private static final Logger logger = LoggerFactory.getLogger(SomeServiceController.class);

    @GetMapping("/api/someService")
    public SimpleResponse someService() {
        return new SimpleResponse("Hi from someService!!!");
    }
}
