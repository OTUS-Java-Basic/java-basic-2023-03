package ru.otus.game;

public class DiceImplTest {
    public void testRoll() {
        Dice dice = new DiceImpl();
        int result = dice.roll();
        if (result >= 1 && result <= 6) {
            System.out.println("Test passed: Roll result is within the valid range.");
        } else {
            System.err.println("Test failed: Roll result is outside the valid range.");
        }
    }
}
