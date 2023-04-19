package ru.otus.java.demo;

public class HumanExample {
    public static void main(String[] args) {
        // Создайте любой примитив
        int a = 5;
        // Создайте ссылочный тип String
        String str = new String("строка");
        System.out.println(str);
        System.out.println(str.repeat(10));
        // найдите тут Ссылочный тип
        // Создайте человека
        Human h = new Human("Pavel", 10);
        h.hello();
        // вызовите метод у человека
    }
}
