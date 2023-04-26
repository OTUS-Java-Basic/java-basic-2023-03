package ru.otus;

public class Start {
    public static void main(String[] args) {
        int firstValue = 0;
        int secondValue = 10;
        int result = sum(firstValue, secondValue);
        System.out.println(result);

        int s2 = 7;
        int s4 = 10;
        int result1 = sum(s2, s4);
        System.out.println(result1);

        int s5 = 0;
        int s6 = 0;
        int result3 = sum(s2, s4);
        System.out.println(result3);
    }

    private static int sum(int firstValue, int secondValue) {
        int result = firstValue + secondValue;
        return result;
    }
}
