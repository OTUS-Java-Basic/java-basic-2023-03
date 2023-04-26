package ru.otus.heavy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.otus.heavy.Message.CITY;
import static ru.otus.heavy.Message.FULL_NAME_MESSAGE;

@SuppressWarnings("all")
public class HeavyCase02 {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    // Примерно 7 недочетов
    public static void main(String[] args) throws IOException {
        printText("Hello");
        printText("Hello", "By");
        printText("Давайте заполним почтовое извещение");
        var fullName = getStringWithPrintedText(FULL_NAME_MESSAGE.getText());
        var townOfLiving = getStringWithPrintedText(CITY.getText());
        var postIndex = getStringWithPrintedText("Почтовый индекс");
        var passportNumber = getStringWithPrintedText("Номер паспорта");
        var passportSeries = getStringWithPrintedText("Серия паспорта");
        var issuedBy = getStringWithPrintedText("Кем выдан");
        printText("Отлично! Извещение заполнено, пожалуйста проверьте введенные данные");
        printText(fullName, townOfLiving, postIndex, passportNumber, passportSeries, issuedBy);
        printText("До свидания");
    }

    private static void printText(String fullName, String townOfLiving, String postIndex, String passportNumber, String passportSeries, String issuedBy) {
        printText("fullName: " + fullName);
        printText("townOfLiving: " + townOfLiving);
        printText("postIndex: " + postIndex);
        printText("passportNumber: " + passportNumber);
        printText("passportSeries: " + passportSeries);
        printText("issuedBy: " + issuedBy);
    }

    private static String getStringWithPrintedText(String text) throws java.io.IOException {
        printText(text);
        return BUFFERED_READER.readLine();
    }

    private static void printText(String... text) {
        for (int i = 0; i < text.length; i++) {
            System.out.println(text[i]);
        }
    }
}

enum Message {
    FULL_NAME_MESSAGE("Ваше ФИО"),
    CITY("Город проживания");

    public String getText() {
        return text;
    }

    private final String text;

    Message(String text) {
        this.text = text;
    }
}
