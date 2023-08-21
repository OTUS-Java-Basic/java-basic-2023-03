package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.game.DiceImpl;

public class DiceImplTest {
    @DisplayName("Ранжир броска кубика")
    @Test
    void testRoll() {
        int count = 0;
        int roll;
        DiceImpl dice = new DiceImpl();
            while (count < 10) {
                roll = dice.roll();
                System.out.println(roll);
                count++;
                assert(roll >= 1);
                assert(roll <= 6);
            }
    }
}
