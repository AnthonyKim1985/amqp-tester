package com.example.amqptester.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(of = "message")
public class DefaultResponse {
    private String message;
}
