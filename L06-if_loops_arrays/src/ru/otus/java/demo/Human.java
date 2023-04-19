package ru.otus.java.demo;

public class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hello() {
        System.out.println("My name is " + name + " and my age is " + age);
    }

    public String walk(int killometers) {
        return "Я прошелся " + killometers + " килиметров";
    }
}
