/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.restapi.controlers;

import com.stulsoft.pspring.restapi.data.Data1;
import com.stulsoft.pspring.restapi.data.Data1UpdateRequest;
import com.stulsoft.pspring.restapi.data.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author Yuriy Stul
 */
@RestController
@RequestMapping("/data1")
public class Data1Provider {
    private final Random random = new Random();

    @GetMapping("")
    public Data1 data1() {
        Object anObject = random.nextBoolean() ? 123L : "string";
        return new Data1("test1", 25, anObject, null);
    }

    @PostMapping("")
    public Result update1(@RequestBody Data1UpdateRequest request) {
        System.out.println("==>update1");
        System.out.println("request: " + request.toString());
        if (request.age() < 10) {
            return new Result(false, String.format("age [%d] < 10", request.age()));
        } else {
            return new Result(true, "");
        }
    }
}
