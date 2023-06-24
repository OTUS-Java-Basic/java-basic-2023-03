package ru.otus;

import ru.otus.game.*;

import java.util.Collection;

public class Demo {

    public static void main(String[] args) {
        Dice dice = new DiceImpl();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter() {
            @Override
            public Player getWinner() {
                return null;
            }

            @Override
            public Collection<Object> getErrorOutput() {
                return null;
            }
        };
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));
    }
}
