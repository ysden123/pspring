package com.stulsoft.pspring.ssm1;

import com.stulsoft.pspring.ssm1.sm1.Events;
import com.stulsoft.pspring.ssm1.sm1.States;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class App {
    private final StateMachine<States, Events> stateMachine1;
    private final StateMachine<States, Events> stateMachine2;

    public App(StateMachine<States, Events> stateMachine1,
               StateMachine<States, Events> stateMachine2) {
        this.stateMachine1 = stateMachine1;
        this.stateMachine2 = stateMachine2;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args -> {
            System.out.println("==>main");
            test1();
        });
    }

    private void test1() {
        System.out.println("==>test1");
        Message<Events> message1 = MessageBuilder.withPayload(Events.E1).build();
        Message<Events> message2 = MessageBuilder.withPayload(Events.E2).build();

        stateMachine1.sendEvent(Mono.just(message1)).subscribe();
        stateMachine1.sendEvent(Mono.just(message2)).subscribe();

        System.out.printf("stateMachine1 %s%n", stateMachine1.getState().getIds());

        stateMachine1.sendEvent(Mono.just(message1)).subscribe();

        stateMachine2.sendEvent(Mono.just(message2)).subscribe();
        stateMachine2.sendEvent(Mono.just(message1)).subscribe();
        System.out.printf("stateMachine2 %s%n", stateMachine2.getState().getIds());
    }
}
