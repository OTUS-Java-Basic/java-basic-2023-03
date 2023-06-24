package ru.otus.game;

import java.util.Collection;

public interface GameWinnerPrinter {
    void printWinner(Player winner);

    Player getWinner();

    Collection<Object> getErrorOutput();
}
