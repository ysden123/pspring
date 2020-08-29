/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pspring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yuriy Stul
 */
@Controller
public class MyExternalIP {
    @GetMapping("/myExternalIP")
    public String myExternalIP(Model model) {
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
            model.addAttribute("ip", s.next());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return "myExternalIP";
    }
}
