import java.util.Scanner;

public class PriceInWords {
    private static final String[] units = {
            "", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };

    private static final String[] tens = {
            "", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
            "восемьдесят", "девяносто"
    };

    static String convertToWords(int number) {
        if (number == 0) {
            return "ноль";
        }

        if (number < 0) {
            return "минус " + convertToWords(Math.abs(number));
        }

        String words = " ";

        if (number / 1000000 > 0) {
            words += convertToWords(number / 1000000) + " миллион ";
            number %= 1000000;
        }

        if (number / 1000 > 0) {
            words += convertToWords(number / 1000) + " тысяча ";
            number %= 1000;
        }

        if (number / 100 > 0) {
            words += units[number / 100] + " сто ";
            number %= 100;
        }

        if (number > 0) {
            if (number < 20) {
                words += units[number] + " ";
            } else {
                words += tens[number / 10] + " ";
                number %= 10;

                if (number > 0) {
                    words += units[number] + " ";
                }
            }
        }

        return words.trim();
    }

    static String getCurrencyWord(int number) {
        if (number % 10 == 1 && number % 100 != 11) {
            return " рубль";
        } else if ((number % 10 >= 2 && number % 10 <= 4) && (number % 100 < 10 || number % 100 >= 20)) {
            return " рубля";
        } else {
            return " рублей";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        String words = convertToWords(number);
        String currencyWord = getCurrencyWord(number);

        if (number >= 100 && number % 100 == 0) {
            words = words.replace("сто", "сто");
        } else if (number >= 100 && number % 100 < 20) {
            words = words.replace("один сто", "сто");
        } else if (number >= 100 && number % 100 >= 20) {
            words = words.replace("один", "одна");
        }

        System.out.println(words + currencyWord);
    }
}

class PriceInWordsTest {
    public static void main(String[] args) {
        testConvertToWords();
        testGetCurrencyWord();
        testMainLogic();
    }

    private static void testConvertToWords() {
        System.out.println("Тест правильности конвертации цифры в пропись");

        // сам тест, взял рандомные числа
        int[] numbers = {0, 5, 11, 25, 123, 1000, 1500, 9999, 12034, 1234567};
        String[] expectedResults = {
                "ноль", "пять", "одиннадцать", "двадцать пять", "сто двадцать три",
                "одна тысяча", "одна тысяча пятьсот", "девять тысяч девятьсот девяносто девять",
                "двенадцать тысяч тридцать четыре", "один миллион двести тридцать четыре тысячи пятьсот шестьдесят семь"
        };

        for (int i = 0; i < numbers.length; i++) {
            String result = PriceInWords.convertToWords(numbers[i]);
            if (result.equals(expectedResults[i])) {
                System.out.println("Тест кейс " + (i + 1) + " пройден успешно");
            } else {
                System.out.println("Тест кейс " + (i + 1) + " провален. Должно быть: " + expectedResults[i] + ", Получили: " + result);
            }
        }
    }

    private static void testGetCurrencyWord() {
        System.out.println("Проверка склонения слова рубль");

        // сам тест, 5 тест кейс специально с ошибкой
        int[] numbers = {1, 2, 5, 10, 11, 21, 25, 100, 101, 112, 120};
        String[] expectedResults = {
                " рубль", " рубля", " рублей", " рублей", " рубль", " рубль", " рублей", " рублей", " рубль", " рублей", " рублей"
        };

        for (int i = 0; i < numbers.length; i++) {
            String result = PriceInWords.getCurrencyWord(numbers[i]);
            if (result.equals(expectedResults[i])) {
                System.out.println("Тест кейс " + (i + 1) + " пройден успешно");
            } else {
                System.out.println("Тест кейс " + (i + 1) + " провален. Ожидаем: " + expectedResults[i] + ", Получили: " + result);
            }
        }
    }

    private static void testMainLogic() {
        System.out.println("Тест логики метода main");

        simulateUserInputAndCompare(500, "пятьсот рублей");

        System.out.println("Тесты завершены успешно");
    }

    private static void simulateUserInputAndCompare(int number, String expectedOutput) {
        System.out.println("Имитация пользовательского ввода: " + number);
        String words = PriceInWords.convertToWords(number);
        String currencyWord = PriceInWords.getCurrencyWord(number);

        if (number >= 100 && number % 100 == 0) {
            words = words.replace("сто", "сто");
        } else if (number >= 100 && number % 100 < 20) {
            words = words.replace("один сто", "сто");
        } else if (number >= 100 && number % 100 >= 20) {
            words = words.replace("один", "одна");
        }

        String expectedResult = words + currencyWord;

        if (expectedResult.equals(expectedOutput)) {
            System.out.println("Тест пройден. Вывод: " + expectedOutput);
        } else {
            System.out.println("Тест провален. Ожидаем: " + expectedOutput + ", Получили: " + expectedResult);
        }
    }
}