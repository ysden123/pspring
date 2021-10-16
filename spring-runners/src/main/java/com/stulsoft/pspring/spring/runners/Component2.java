/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.spring.runners;

import org.springframework.stereotype.Component;

/**
 * @author Yuriy Stul
 */
@Component
public class Component2 {
    private final Component1 component1;

    public Component2(Component1 component1) {
        this.component1 = component1;
    }

    public void func2(){
        System.out.println("==>func2");
        component1.func1();
    }
}
