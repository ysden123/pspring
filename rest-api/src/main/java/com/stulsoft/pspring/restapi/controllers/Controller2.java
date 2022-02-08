/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pspring.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class Controller2 {
    @Autowired
    Controller1 controller1;

    @GetMapping("/foo")
    public String foo(){
        return controller1.foo();
    }

    @GetMapping("/bar")
    public String bar() {
        return "bar v2";
    }
}
