/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.restapi.controllers;

import com.stulsoft.pspring.restapi.data.Data1;
import com.stulsoft.pspring.restapi.data.Data2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Yuriy Stul
 */
@RestController
@RequestMapping("/data2")
public class Data2Provider {
    @GetMapping("")
    public Data2 data2() {
        var data1List = Arrays.asList(
                new Data1("d1",1, null, null),
                new Data1("d2",2, 654, null),
                new Data1("d3",3, "text", null)
                );

        return new Data2("name 1", data1List);
    }
}
