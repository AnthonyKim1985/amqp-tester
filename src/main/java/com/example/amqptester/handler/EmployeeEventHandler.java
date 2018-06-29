package com.example.amqptester.handler;

import com.example.amqptester.config.RabbitMQConfig;
import com.example.amqptester.domain.Employee;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log
@RabbitListener(queues = {RabbitMQConfig.QueueName})
@Component
public class EmployeeEventHandler implements EventHandler {
    @Override
    @RabbitHandler
    public void process(Employee employee) {
        log.info(employee.toString());
    }
}
