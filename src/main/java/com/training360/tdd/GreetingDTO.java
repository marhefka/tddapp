package com.training360.tdd;

public class GreetingDTO {
    private String name;

    public GreetingDTO() {
    }

    public GreetingDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
