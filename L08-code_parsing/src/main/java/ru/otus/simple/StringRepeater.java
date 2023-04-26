package ru.otus.simple;

import java.util.Scanner;

// Найти примерно 7 недочетов. Решить, как будем исправлять.

@SuppressWarnings("all")
public class StringRepeater {
    public static void main(String[] args) {
        String inputString = getUserInputAsString();
        String repeatedString = getRepeatedString(inputString, 10);
        System.out.println(repeatedString);
    }

    private static String getUserInputAsString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String getRepeatedString(String s, int numberOfRepetitions) {
        String repeatedString = s.repeat(numberOfRepetitions);
        return repeatedString;
    }
}
