package com.stulsoft.pspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello World!";
    }
}
