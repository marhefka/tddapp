package com.training360.tdd;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
