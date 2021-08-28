/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.restapi.controllers;

import com.stulsoft.pspring.restapi.data.AbstractResult;
import com.stulsoft.pspring.restapi.data.Data1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author Yuriy Stul
 */
@RestController
@RequestMapping("/data12")
public class Data1Provider2 {
    private final Random random = new Random();

    @GetMapping("")
    public ResponseEntity<AbstractResult<Data1>> data1() {
        Object anObject = random.nextBoolean() ? 123L : "string";
        var data = new Data1("test1", 25, anObject, null);
        var responseData = new AbstractResult<>(data, "");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/withError")
    public ResponseEntity<AbstractResult<Data1>> data1WithError() {
        var responseData = new AbstractResult<Data1>(null, "Some error was found");
        return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
    }

}
