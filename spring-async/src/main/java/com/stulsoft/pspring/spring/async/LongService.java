/*
 * Copyright (c) 2021. Webpals
 */

package com.stulsoft.pspring.spring.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuriy Stul
 */
@Service
public class LongService {
    private static final Logger logger = LoggerFactory.getLogger(LongService.class);

    @Async
    public CompletableFuture<String> func(String text){
        logger.info("==>func ({})", text);
        try{
            Thread.sleep(789);
            return CompletableFuture.completedFuture("Done for " + text);
        }catch(Exception exception){
            return CompletableFuture.failedFuture(exception);
        }
    }
}
