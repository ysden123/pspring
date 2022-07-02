package com.stulsoft.pspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyExternalIP {
    @GetMapping("/myExternalIP")
    public String myExternalIP() {
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(),
                "UTF-8")
                .useDelimiter("\\A")) {
            return "ip: " + s.next();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}