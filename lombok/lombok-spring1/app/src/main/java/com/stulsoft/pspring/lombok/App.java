package com.stulsoft.pspring.lombok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class App {
    @Autowired
    AppConfig appConfig;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Bean
    public CommandLineRunner demo() {
        return (args -> {
            log.info("==>main");
            test1();
        });
    }

    private void test1(){
        appConfig.showConfig();
    }
}
