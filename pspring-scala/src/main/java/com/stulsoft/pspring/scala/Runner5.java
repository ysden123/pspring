package com.stulsoft.pspring.scala;

import org.springframework.boot.SpringApplication;

/**
 * @author Yuriy Stul
 * @since 4/1/2018
 */
public class Runner5 {
    public static void main(String[] args) {
        System.out.println("==>main");
        Object applications[] = {Application2.class, Application3.class};
        SpringApplication.run(applications, args).close();
        System.out.println("<==main");
    }
}
