import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTest {
    @DisplayName("Проверка числового ввода")
    @Test
    void isNumericTest() {
        String value = "aaaaa";
        Assertions.assertFalse(Main.isNumeric(value));
        value = "12345";
        Assertions.assertTrue(Main.isNumeric(value));
    }
    @DisplayName("Проверка числового ввода")
    @Test
    void isPositiveTest() {
        String value = "-2";
        Assertions.assertFalse(Main.isPositive(value));
        value = "2";
        Assertions.assertTrue(Main.isPositive(value));
    }
    @DisplayName("Разбиение на цифры")
    @Test
    void breakDownToDigitsTest() {
        String value = "1";
        Digit digit1 = new Digit(1, 1);
        List<Digit> digits = new ArrayList<>();
        digits.add(digit1);
        Assertions.assertEquals(digits, Main.breakDownToDigits(value));//Ввод одноразрядного числа
        value = "11";
        digit1 = new Digit(1, 0);
        digits.set(0, digit1);
        Digit digit2 = new Digit(2, 11);
        digits.add(digit2);
        Collections.reverse(digits);
        List<Digit> digitsForTest = Main.breakDownToDigits(value);
        assertObjects(digits, digitsForTest);//Ввод двухразрядного числа
        Collections.reverse(digits);
        value = "111";
        Digit digit3 = new Digit(3, 1);
        digits.add(digit3);
        Collections.reverse(digits);
        digitsForTest = Main.breakDownToDigits(value);
        assertObjects(digits, digitsForTest);//Ввод трехзрядного числа
        Collections.reverse(digits);
        value = "1111";
        Digit digit4 = new Digit(4, 1);
        digits.add(digit4);
        Collections.reverse(digits);
        digitsForTest = Main.breakDownToDigits(value);
        assertObjects(digits, digitsForTest);//Ввод четырехрядного числа
    }
    @DisplayName("Сборка строки")
    @Test
    void stringAssemblyTest() {
        List<Digit> digits = new ArrayList<>();
        Digit digit1 = new Digit(1, 0);
        Digit digit2 = new Digit(2, 11);
        Digit digit3 = new Digit(3, 1);
        Digit digit4 = new Digit(4, 1);
        digits.add(digit1);
        digits.add(digit2);
        digits.add(digit3);
        digits.add(digit4);
        Collections.reverse(digits);
        Assertions.assertEquals("одна тысяча сто одиннадцать рублей", Main.stringAssembly(digits, new UsedCurrency("рубль", "рубля", "рублей")));
    }
    @DisplayName("Получение слова из числа")
    @Test
    void getDigitAsWordTest() {
        Digit digit1 = new Digit(1, 0);
        Digit digit2 = new Digit(2, 11);
        Digit digit3 = new Digit(3, 1);
        Digit digit4 = new Digit(4, 1);
        Assertions.assertEquals("", Main.getDigitAsWord(digit1));
        Assertions.assertEquals("одиннадцать", Main.getDigitAsWord(digit2));
        Assertions.assertEquals("сто",Main.getDigitAsWord(digit3));
        Assertions.assertEquals("одна тысяча",Main.getDigitAsWord(digit4));
    }
    private void assertObjects(List<Digit> digits, List<Digit> digitsForTest) {
        for (int i=0; i < digits.size(); i++) {
            Assertions.assertEquals(digits.get(i).getDigitID(), digitsForTest.get(i).getDigitID());
            Assertions.assertEquals(digits.get(i).getValue(), digitsForTest.get(i).getValue());
        }
    }
}
