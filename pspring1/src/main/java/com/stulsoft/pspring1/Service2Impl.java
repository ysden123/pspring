/*
 * Copyright (c) 2017, Yuriy Stul. All rights reserved
 */
package com.stulsoft.pspring1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Yuriy Stul.
 */
@Component
public class Service2Impl implements IService2 {
    private Random random = new Random();

    @Override
    public int getNextInt() {
        return random.nextInt();
    }
}
