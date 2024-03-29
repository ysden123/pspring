package com.stulsoft.pspring.ssm1.sm1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@Scope("prototype")
@EnableStateMachine
public class StateMachineConfig1 extends EnumStateMachineConfigurerAdapter<States, Events> {
    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> configure) throws Exception {
        configure
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.SI)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.SI).target(States.S1).event(Events.E1)
                .and()
                .withExternal()
                .source(States.S1).target(States.S2).event(Events.E2);
    }

    private StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                if (from == null)
                    System.out.printf("State change to %s%n", to.getId());
                else
                    System.out.printf("State change from %s to %s%n", from.getId(), to.getId());
            }
        };
    }
}
