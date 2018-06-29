package com.example.amqptester.handler;

import com.example.amqptester.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventHandler {
    @RabbitHandler
    void process(@Payload Employee employee);
}
