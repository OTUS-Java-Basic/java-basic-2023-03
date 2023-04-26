package ru.otus.heavy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("all")
public class HeavyCase01 {
    private static final String[] MOVIES = new String[]{"Клерки", "Довод", "Джентльмены", "Конёк-Горбунок"};
    private static final int[] USER_ALLOWED_AGE_FOR_MOVIE = new int[]{18, 16, 18, 6};
    private static final int[] MOVIES_COST = new int[]{350, 750, 500, 300};

    // Две ошибки (почти), примерно 4 недочета
    public static void main(String[] args) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        var movieName = getStringWithPrintedText(bufferedReader, "Введите название");
        var userAgeAsString = getStringWithPrintedText(bufferedReader, "Введите возраст");
        int userAge = Integer.parseInt(userAgeAsString);
        var expectedMovieCostAsString = getStringWithPrintedText(bufferedReader, "Введите цену");
        int expectedMovieCost = Integer.parseInt(expectedMovieCostAsString);

        var canUserBuyTicket = false;
        for (int i = 0; i < MOVIES.length; i++) {
            if (checkIsUserCanBuyATicket(movieName, userAge, expectedMovieCost, i)) {
                canUserBuyTicket = true;
                break;
            }
        }

        String message = canUserBuyTicket
                ? "Вам можно купить билет на выбранный сеанс"
                : "Вы не можете купить билет на выбранный сеанс";
        System.out.println(message);
    }

    private static boolean checkIsUserCanBuyATicket(String movieName, int userAge, int expectedMovieCost, int i) {
        return MOVIES[i].equals(movieName)
                && USER_ALLOWED_AGE_FOR_MOVIE[i] <= userAge
                && MOVIES_COST[i] <= expectedMovieCost;
    }

    private static String getStringWithPrintedText(java.io.BufferedReader br, String text) throws java.io.IOException {
        System.out.println(text);
        String n = br.readLine();
        return n;
    }
}
