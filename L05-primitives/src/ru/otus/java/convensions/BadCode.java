package ru.otus.java.convensions;

// Что здесь можно улучшить (синтаксически)?
// Логику работы, алгоритм улучшать не надо.
// Пишите в чат номер строки и что в ней исправить.

public class BadCode {

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);


        int zzzz = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int result = i * j;
                String str = String.valueOf(result);
                String revers = new StringBuffer(str).reverse().toString();
                int newB = Integer.parseInt(revers);
                if (newB == result) {
                    int answer1 = result;
                    // int answer1 = result * 2;
                    //TODO int answer1 = result * 2;
                    if (answer1 > zzzz) zzzz = answer1;
                }
            }
        }
        System.out.println(zzzz);

    }
}