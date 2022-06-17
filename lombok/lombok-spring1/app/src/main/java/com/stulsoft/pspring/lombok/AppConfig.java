package com.stulsoft.pspring.lombok;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@EnableAutoConfiguration
public class AppConfig {
    @Value("${app.param1}")
    private Integer param1;

    public void showConfig(){
        log.info("param1 = {}", param1);
    }
}
