package com.example.amqptester;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class AmqpTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpTesterApplication.class, args);
    }
}
