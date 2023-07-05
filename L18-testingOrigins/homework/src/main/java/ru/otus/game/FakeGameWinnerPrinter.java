package ru.otus.game;

public class FakeGameWinnerPrinter implements GameWinnerPrinter {
    private boolean printWinnerCalled = false;

    @Override
    public void printWinner(Player winner) {
        printWinnerCalled = true;
    }

    public boolean isPrintWinnerCalled() {
        return printWinnerCalled;
    }
}