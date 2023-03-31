package com.springboot.restApiDemo.restapi.demo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "employees")
@NoArgsConstructor
public class Employee {
    @Getter
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String first_name;

    @Getter
    @Setter
    private String last_name;

    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    @Column(unique = true)
    private String phoneNumber;

}
