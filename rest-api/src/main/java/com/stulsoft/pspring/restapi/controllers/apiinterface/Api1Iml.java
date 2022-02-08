/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pspring.restapi.controllers.apiinterface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Api1Iml implements Api1{
    @GetMapping("/fooFoo")
    @Override
    public String fooFoo() {
        return "Api1 fooFoo";
    }
}
