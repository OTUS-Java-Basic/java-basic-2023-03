package ru.otus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.game.*;

public class GameTest {
    @DisplayName("Победа первого игрока:")
    @Test
    void testPlayerOneWin() {
        //Подготовка
        Player one = new Player("Олег");
        Player two = new Player("Илья");
        Dice dice = new Dice(){
            private int count = 0;
            @Override
            public int roll() {
                if (count == 0) {
                    count++;
                    return 6;
                }
                return 1;
            }
        };
        GameWinnerPrinter printer = new GameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {
                //Проверки
                Assertions.assertEquals("Олег", winner.getName());
            }
        };
        Game game = new Game(dice, printer);
        //Действия
        game.playGame(one, two);
    }
    @DisplayName("Победа Второго игрока:")
    @Test
    void testPlayerTwoWin() {
        //Подготовка
        Player one = new Player("Олег");
        Player two = new Player("Илья");
        Dice dice = new Dice(){
            private int count = 0;
            @Override
            public int roll() {
                if (count == 0) {
                    count++;
                    return 1;
                }
                return 6;
            }
        };
        GameWinnerPrinter printer = new GameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {
                //Проверки
                Assertions.assertEquals("Илья", winner.getName());
            }
        };
        Game game = new Game(dice, printer);
        //Действия
        game.playGame(one, two);
    }
    @DisplayName("Ничья:")
    @Test
    void testDraw() {
        //Подготовка
        Player one = new Player("Олег");
        Player two = new Player("Илья");
        Dice dice = new Dice(){
            @Override
            public int roll() {
                return 1;
            }
        };
        GameWinnerPrinter printer = new GameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {
                //Проверки
                Assertions.assertEquals("Ничья", winner.getName());
            }
        };
        Game game = new Game(dice, printer);
        //Действия
        game.playGame(one, two);
    }
}
