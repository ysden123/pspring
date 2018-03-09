/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.pspring1.pinject;

import org.springframework.stereotype.Component;

@Component
public class Service1Impl implements Service1{
    @Override
    public void print() {
        System.out.println("Service1Impl::print");
    }
}
