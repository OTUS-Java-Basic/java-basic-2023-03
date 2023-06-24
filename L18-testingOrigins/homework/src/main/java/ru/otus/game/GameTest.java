package ru.otus.game;

import java.util.Collection;

public class GameTest {
    public void testPlayGame_Player1Wins() {
        // Создаем фейковые объекты Dice и GameWinnerPrinter
        Dice dice = new FakeDice(6, 1) {
            @Override
            public int roll() {
                return 0;
            }
        }; // player1Result > player2Result
        GameWinnerPrinter winnerPrinter = new FakeGameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {

            }

            @Override
            public Player getWinner() {
                return null;
            }

            @Override
            public Collection<Object> getErrorOutput() {
                return null;
            }
        };
        // Создаем экземпляр класса Game
        Game game = new Game(dice, winnerPrinter);

        // Создаем двух игроков
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Вызываем метод playGame
        game.playGame(player1, player2);

        // Проверяем, что победитель - player1
        if (winnerPrinter.getWinner() == player1) {
            System.out.println("Test passed: Player 1 wins.");
        } else {
            System.err.println("Test failed: Player 1 should win.");
        }
    }

    public void testPlayGame_Player2Wins() {
        // Создаем фейковые объекты Dice и GameWinnerPrinter
        Dice dice = new FakeDice(2, 4) {
            @Override
            public int roll() {
                return 0;
            }
        }; // player1Result < player2Result
        GameWinnerPrinter winnerPrinter = new FakeGameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {

            }

            @Override
            public Player getWinner() {
                return null;
            }

            @Override
            public Collection<Object> getErrorOutput() {
                return null;
            }
        };
        // Создаем экземпляр класса Game
        Game game = new Game(dice, winnerPrinter);

        // Создаем двух игроков
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Вызываем метод playGame
        game.playGame(player1, player2);

        // Проверяем, что победитель - player2
        if (winnerPrinter.getWinner() == player2) {
            System.out.println("Test passed: Player 2 wins.");
        } else {
            System.err.println("Test failed: Player 2 should win.");
        }
    }

    public void testPlayGame_Draw() {
        // Создаем фейковые объекты Dice и GameWinnerPrinter
        Dice dice = new FakeDice(3, 3) {
            @Override
            public int roll() {
                return 0;
            }
        }; // player1Result = player2Result
        GameWinnerPrinter winnerPrinter = new FakeGameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {

            }

            @Override
            public Player getWinner() {
                return null;
            }

            @Override
            public Collection<Object> getErrorOutput() {
                return null;
            }
        };
        // Создаем экземпляр класса Game
        Game game = new Game(dice, winnerPrinter);

        // Создаем двух игроков
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Вызываем метод playGame
        game.playGame(player1, player2);

        // Проверяем, что нет победителя
        if (winnerPrinter.getWinner() == null) {
            System.out.println("Test passed: Draw, no winner.");
        } else {
            System.err.println("Test failed: There should be no winner.");
        }
    }

    public void testPlayGame_DiceRollError() {
        // Создаем фейковые объекты Dice и GameWinnerPrinter
        Dice dice = new FakeDiceWithError() {
            @Override
            public int roll() {
                return 0;
            }
        };
        GameWinnerPrinter winnerPrinter = new FakeGameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {

            }

            @Override
            public Player getWinner() {
                return null;
            }

            @Override
            public Collection<Object> getErrorOutput() {
                return null;
            }
        };
        // Создаем экземпляр класса Game
        Game game = new Game(dice, winnerPrinter);

        // Создаем двух игроков
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Вызываем метод playGame
        game.playGame(player1, player2);

        // Проверяем, что нет победителя
        if (winnerPrinter.getWinner() == null && winnerPrinter.getErrorOutput().contains("Ошибка при броске кости")) {
            System.out.println("Test passed: Error handled correctly.");
        } else {
            System.err.println("Test failed: Error handling is incorrect.");
        }
    }
}
