/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pspring.restapi.controllers.apiinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class Api2Iml implements Api1, Api2{
    @Autowired
    Api1 api1;

    @GetMapping("/fooFoo")
    @Override
    public String fooFoo() {
        return api1.fooFoo();
    }

    @GetMapping("/barBar")
    @Override
    public String barBar() {
        return "Api2 barBar";
    }
}
