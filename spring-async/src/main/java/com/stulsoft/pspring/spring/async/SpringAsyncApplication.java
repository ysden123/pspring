package com.stulsoft.pspring.spring.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Stream;

@SpringBootApplication
@EnableAsync
public class SpringAsyncApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringAsyncApplication.class);

    @Autowired
    private LongService longService;

    public static void main(String[] args) {
        logger.info("==>main");
        SpringApplication.run(SpringAsyncApplication.class, args).close();
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("SpringAsync-");
        executor.initialize();
        return executor;
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("==>run");
        var result1 = longService.func("test1");
        var result2 = longService.func("test2");
        var result3 = longService.func("test3");
        var result4 = longService.func("test4");
        Stream.of(result1, result2, result3, result4)
                .map(CompletableFuture::join)
                .forEach(result -> logger.info("result = {}", result));

        var totalResult = longService.func("test5")
                .thenApply(s-> longService.func(s))
                .get();
        logger.info("totalResult: {}", totalResult.get());
    }
}
