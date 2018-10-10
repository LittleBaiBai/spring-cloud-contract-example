package com.example.demo;

public class Kitten {
    private String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private int age;

    public Kitten() {
    }

    public Kitten(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
