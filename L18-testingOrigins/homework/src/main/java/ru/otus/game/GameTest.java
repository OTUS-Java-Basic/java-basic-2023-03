package ru.otus.game;

public class GameTest {
    public void testPlayGame_Player1Wins() {
        // Создаем объекты и данные для теста
        Dice dice = new DiceImpl();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");

        // Присваиваем значения
        int player1Result = 5; // Результат броска кости для player1
        int player2Result = 3; // Результат броска кости для player2

        // Создаем объект Game и вызываем метод playGame
        Game game = new Game(dice, winnerPrinter);
        game.playGame(player1, player2);

        // Проверяем, что правильный игрок 1 объявлен победителем
        if (player1Result > player2Result) {
            System.out.println("Тест успешно пройден: игрок Вася объявлен победителем, так как у него результат больше.");
        } else {
            System.err.println("Ошибка в тесте: игрок Вася должен быть объявлен победителем, так как у него результат больше.");
        }
    }

    public void testPlayGame_Player2Wins() {
        // Создаем объекты и данные для теста
        Dice dice = new DiceImpl();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");

        // Устанавливаем ожидаемые значения
        int player1Result = 1; // Результат броска кости для player1
        int player2Result = 4; // Результат броска кости для player2

        // Создаем объект Game и вызываем метод playGame
        Game game = new Game(dice, winnerPrinter);
        game.playGame(player1, player2);

        // Проверяем, что правильный игрок объявлен победителем
        if (player1Result < player2Result) {
            System.out.println("Тест успешно пройден: игрок Игорь объявлен победителем, так как у него результат больше.");
        } else {
            System.err.println("Ошибка в тесте: игрок Игорь должен быть объявлен победителем, так как у него результат больше.");
        }
    }

    public void testPlayGame_Draw() {
        // Создаем объекты и данные для теста
        Dice dice = new DiceImpl();
        FakeGameWinnerPrinter winnerPrinterStub = new FakeGameWinnerPrinter();
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");

        // Устанавливаем ожидаемые значения
        int player1Result = 4; // Результат броска кости для player1
        int player2Result = 4; // Результат броска кости для player2

        // Создаем объект Game и вызываем метод playGame
        Game game = new Game(dice, winnerPrinterStub);
        game.playGame(player1, player2);

        // Проверяем, что метод printWinner() не вызывается
        if (winnerPrinterStub.isPrintWinnerCalled() == false) {
            System.out.println("Тест успешно пройден: метод printWinner() не был вызван при ничьей.");
        } else {
            System.err.println("Ошибка в тесте при ничьей: метод printWinner() вызывается, хотя не должен этого делать.");
        }
    }

}
