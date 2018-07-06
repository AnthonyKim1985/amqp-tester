package com.example.amqptester.service;

import com.example.amqptester.domain.Employee;
import com.example.amqptester.domain.Member;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Log
@Service
public class MessageQueueService {
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(
                            value = "member"
                    ),
                    exchange = @Exchange(
                            value = "member-exchange",
                            type = org.springframework.amqp.core.ExchangeTypes.TOPIC,
                            durable = "true"
                    )
            )
    )
    public void processMember(@Payload Member member) {
        log.info(member.toString());
    }


    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(
                            value = "employee"
                    ),
                    exchange = @Exchange(
                            value = "employee-exchange",
                            type = org.springframework.amqp.core.ExchangeTypes.TOPIC,
                            durable = "true"
                    )
            )
    )
    public void processEmployee(@Payload Employee employee) {
        log.info(employee.toString());
    }
}
