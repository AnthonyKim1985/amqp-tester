package com.example.amqptester.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = "email")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    private String email;
    private String name;
}
