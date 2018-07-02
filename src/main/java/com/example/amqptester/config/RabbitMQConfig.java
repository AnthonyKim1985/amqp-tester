package com.example.amqptester.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QueueName = "amqp-tester";
    public static final String SecondaryQueueName = "amqp-tester-2";

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(QueueName, false);
    }

    @Bean
    public Binding binding(@Qualifier("topicExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue()).to(exchange)
                .with(queue().getName());
    }

    @Bean
    public Queue secondaryQueue() {
        return new Queue(SecondaryQueueName, false);
    }

    @Bean
    public Binding secondaryBinding(@Qualifier("topicExchangeForSecondary") TopicExchange exchange) {
        return BindingBuilder.bind(secondaryQueue()).to(exchange)
                .with(secondaryQueue().getName());
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(QueueName + "-exchange");
    }

    @Bean
    public TopicExchange topicExchangeForSecondary() {
        return new TopicExchange(SecondaryQueueName + "-exchange");
    }
}