import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsedCurrenTest {
    @DisplayName("Вывод правильного падежа вылюты")
    @Test
    void testGetNameUnits() {
        UsedCurrency currency = new UsedCurrency("рубль", "рубля", "рублей");
        Digit digit1 = new Digit(1,1);
        Assertions.assertEquals("рубль", currency.getNameUnits(digit1,currency));
        digit1 = new Digit(1, 3);
        Assertions.assertEquals("рубля", currency.getNameUnits(digit1,currency));
        digit1 = new Digit(1, 7);
        Assertions.assertEquals("рублей", currency.getNameUnits(digit1,currency));
    }
}
