package ru.otus.game;

public class DiceImplTest {
    public void testRoll() {
        Dice dice = new DiceImpl();
        int result = dice.roll();
        if (result >= 1 && result <= 6) {
            System.out.println("Тест успешно пройден: результат броска кости корректен.");
        } else {
            System.err.println("Ошибка в тесте: результат броска кости должен быть от 1 до 6.");
        }
    }
}