package com.stulsoft.pspring.scala;

import org.springframework.boot.SpringApplication;

/**
 * @author Yuriy Stul
 * @since 4/1/2018
 */
public class Runner6 {
    public static void main(String[] args) {
        System.out.println("==>Runner6.main");
        Object applications[] = {Application4.class, Application5.class};
        SpringApplication.run(applications, args).close();
        System.out.println("<==Runner6.main");
    }
}
