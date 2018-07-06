package com.example.amqptester.controller;

import com.example.amqptester.domain.DefaultResponse;
import com.example.amqptester.domain.Employee;
import com.example.amqptester.domain.Member;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public TestController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("employee")
    @ResponseBody
    public DefaultResponse employee(@RequestBody Employee employee) {
        rabbitTemplate.convertAndSend("employee", employee);
        return new DefaultResponse(employee.toString());
    }

    @PostMapping("member")
    @ResponseBody
    public DefaultResponse member(@RequestBody Member member) {
        rabbitTemplate.convertAndSend("member", member);
        return new DefaultResponse(member.toString());
    }
}
