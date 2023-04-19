package ru.otus.java.demo;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
//
//        System.out.print("Введите любое целое число от 1 до 10: ");
//        int number = console.nextInt();
//        System.out.println("Вы ввели число " + number);
//
//        System.out.print("Введите тест: ");
//        String str = console.next();
//        System.out.println("Вы ввели текст " + str);

        int result = 0;
        int firstValue = 10;
        int secondValue = 5;
        String operator = console.nextLine(); // + - *
        boolean equals = operator.equals("+");
        if (equals) {
            result = firstValue + secondValue;
        } else if (operator.equals("-")) {

        }

        int result2 = equals ? firstValue + secondValue : firstValue - secondValue;

        System.out.println("switch");

        switch (operator) {
            case "+":
                result = firstValue + secondValue;
//                break;
            case "-":
                result = firstValue - secondValue;
                break;
            default:
                System.out.println("Неизвестная операция");
                break;
        }

        switch (operator) {
            case "+" -> result = firstValue + secondValue;
            case "-" -> result = firstValue - secondValue;
            default -> System.out.println("Неизвестная операция");
        }
        System.out.println(result);

        System.out.println("===== for ====");
        for (int i = 0; i < 3; i++) { // index
            System.out.println("Hello");
            System.out.println("By");
        }

        System.out.println("===== super for ====");

        int i = 0;
        for (; ; ) { // index
            if (i < 3) {
                System.out.println("Hello");
                System.out.println("By");
            } else {
                break;
            }
            i++;
        }

        i = 0;
        System.out.println("===== while ====");
        while (i < 3) {
            System.out.println("Hello");
            System.out.println("By");
            i++;
        }


        System.out.println("===== do while ====");
        i = 100000;
        do {
            System.out.println("Hello");
            System.out.println("By");
            i++;
        } while (i < 3);

        System.out.println("===== array ====");
        int[] array = new int[]{5, 7, 8, 0, 10, 23};


        int[] array1 = {5};
        Human[] array3 = {new ru.otus.java.demo.Human("", 0)};

        int[] array2 = new int[1];
        array2[0] = 1;


        System.out.println("===== array sout ====");
        System.out.println(array);
        int i1 = array[1]; // --> start with 0
        System.out.println(i1);
        System.out.println("===== array without for ====");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);

        System.out.println("===== array for ====");

        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }

        System.out.println("===== array sum ====");
        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            sum += array[j];
        }
        System.out.println(sum);

        System.out.println("===== array out of range ====");
        int res = array[100];

        System.out.println("New line");
    }
}



