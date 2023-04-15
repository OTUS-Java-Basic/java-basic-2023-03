package ru.otus.java.primitives;

public class Operation {
    public static void main(String[] args) {
        // Арифметические
        int n1 = 5;
        int n2 = 2;
        int a = n1 + n2; // Сложение
        int b = n1 - n2; // Вычитание
        float c = n1 / 2.0f; // Деление
        int d = n1 * n2; // Умножение
        int e = n1 % n2; // Остаток от деления

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);


        System.out.println("=".repeat(50));

        // Внимательно при делении целых чисел
        System.out.println("c = " + c); // 5 / 2 (еще здесь есть конкатенация строк)
        // А если изменить тип c на float?

        System.out.println("e = " + e); // 5 % 2
        // Инкремент, декремент
        System.out.println("-- Инкремент, декремент");
        int i = 10;
        System.out.println("i = " + i);
        i++; // Эквивалентно i = i + 1;
        ++i;
        i = i + 6;
        i += 45;
        i = getAnInt(i);
        System.out.println("i++ = " + i);
        i += 5; // Эквивалентно i = i + 5;
        System.out.println("i += 5 -> " + i);


        System.out.println("-- n++ vs ++m" + "=".repeat(30));
        int s = 10;
        int n = 10 + ++s;
        System.out.println("n -> " + n); // Так лучше не писать - лучше n++ в отдельной строке
        System.out.println("s -> " + s); // Так лучше не писать - лучше n++ в отдельной строке


        int m = 1;
        System.out.println("++m -> " + ++m); // Так лучше не писать - лучше ++m в отдельной строке

        System.out.println("n = " + n);
        System.out.println("m = " + m);

        // Логические
        // < > >= <= !
        // || - или, && - и

        System.out.println(false);
        System.out.println(5 > 4);
        System.out.println(5 >= 4);
        System.out.println(5 <= 4);
        System.out.println(!(5 <= 4));

        System.out.println(true || false);
        System.out.println(true && false);
        System.out.println("-- Логические");
        if (n1 > n2) {
            System.out.println("Hello Misha");
        } else {
            System.out.println("By Misha");
        }

        boolean result = n1 > n2;
        System.out.println("result = " + result);

        boolean resultNot = !result;
        System.out.println("!result = " + resultNot);
        //if (n1 != n2)

        System.out.println(true ^ false);
    }

    private static int getAnInt(int i) {
        return i + 1;
    }
}
