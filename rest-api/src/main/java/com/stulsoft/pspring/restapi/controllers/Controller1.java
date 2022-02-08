/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pspring.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller1 {
    @GetMapping("/foo")
    public String foo() {
        return "foo v1";
    }

    @GetMapping("/bar")
    public String bar() {
        return "bar v1";
    }
}
