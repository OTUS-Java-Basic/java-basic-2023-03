import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String value;
        UsedCurrency currency = new UsedCurrency("рубль", "рубля", "рублей");//Задаем название валюты здесь. При смене валюты надо заменить лишь три слова
        int count = 0;
        List<Digit> digits = new ArrayList<>();
        do {
            do {
                do {
                    System.out.println("Введите число:");//запрос числа
                    value = input.nextLine();
                }
                while (!isNumeric(value));//проверка отсутствия букв в вводе
            }
            while (!isPositive(value));//проверка отрицательности числа
            count = value.length();
            if (count > 4) {//сделал только до тысяч, можно дальше, но это просто больше работы, расширение метода getDigitAsWord и breakDownToDigit позволит зайт так далеко, как захочется
                System.out.println("Слишком большое число!");
            }
        }
        while (count > 4);
        digits = breakDownToDigits(value);//разбиваем ввод на отдельные цифры
        for (int i = 0; i < digits.size(); i++) {
            System.out.println(digits.get(i).getDigitID()+" "+digits.get(i).getValue());
        }
        System.out.println(stringAssembly(digits, currency));//собираем вывод из отдельных кусков

    }


    public static boolean isNumeric(String string) {//проверка отсутствия букв в вводе
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositive(String string) {//вроде как можно сделать проще, просто хотел лишний раз поупражняться с try-catch
        try {
            if (String.valueOf(string.charAt(0)).equals("-")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Количество валюты не может быть отрицательным");
            return false;
        }
        return true;
    }

    public static List<Digit> breakDownToDigits(String value) {//разбиваем ввод на отдельные цифры
        List<Digit> digits = new ArrayList<>();
        int id = value.length();
        for (int i = 0; i < value.length(); i++) {
            String read = String.valueOf(value.charAt(i));
            if (id == 2 && Integer.parseInt(read) == 1) {//отдельный случай для чисел с 10 по 19, не придумал выхода проще
                digits.add(new Digit(id, Integer.parseInt(read + value.charAt(i + 1))));
                id--;
                i++;
                digits.add(new Digit(id, 0));
            } else {
                digits.add(new Digit(id, Integer.parseInt(read)));
            }
            id--;
        }
        return digits;//при переходе к десяткам и сотням тысяч придет усложнять метод учитывая необходимость группировки цифр выше 4-го разряда
    }

    public static String stringAssembly(List<Digit> digits, UsedCurrency currency) {//сбор вывода
        StringBuilder string = new StringBuilder();
        for (Digit digit : digits) {
            if (Objects.equals(getDigitAsWord(digit), "")) {
                string.append(getDigitAsWord(digit));
            } else {
                string.append(getDigitAsWord(digit)).append(" ");
            }
        }
        string.append(currency.getNameUnits(digits.get(digits.size()-1), currency));//добавление названия валюты в конце
        return string.toString();
    }

    public static String getDigitAsWord(Digit digit) {//вывод нужного слова в зависимости от значения и разряда. можно расширять сколько заблагорассудится, но я ограничился тысячами
        String word = "";
        switch (digit.getDigitID()) {
            case 1 -> {
                switch (digit.getValue()) {
                    case 1 -> word = "один";
                    case 2 -> word = "два";
                    case 3 -> word = "три";
                    case 4 -> word = "четыре";
                    case 5 -> word = "пять";
                    case 6 -> word = "шесть";
                    case 7 -> word = "семь";
                    case 8 -> word = "восемь";
                    case 9 -> word = "девять";
                    default -> word = "";
                }
            }
            case 2 -> word = switch (digit.getValue()) {
                case 2 -> "двадцать";
                case 3 -> "тридцать";
                case 4 -> "сорок";//Почему именно "сорок"? не понимаю иногда собственный язык, кроме этого момента всё структурированно было
                case 5 -> "пятьдесят";
                case 6 -> "шестьдесят";
                case 7 -> "семьдесят";
                case 8 -> "восемьдесят";
                case 9 -> "девяносто";
                case 10 -> "десять";
                case 11 -> "одиннадцать";
                case 12 -> "двенадцать";
                case 13 -> "тринадцать";
                case 14 -> "четырнадцать";
                case 15 -> "пятнадцать";
                case 16 -> "шестнадцать";
                case 17 -> "семнадцать";
                case 18 -> "восемнадцать";
                case 19 -> "девятнадцать";
                default -> "";
            };
            case 3 -> word = switch (digit.getValue()) {
                case 1 -> "сто";
                case 2 -> "двести";
                case 3 -> "триста";
                case 4 -> "четыреста";
                case 5 -> "пятьсот";
                case 6 -> "шестьсот";
                case 7 -> "семьсот";
                case 8 -> "восемьсот";
                case 9 -> "девятьсот";
                default -> "";
            };
            case 4 -> word = switch (digit.getValue()) {
                case 1 -> "одна тысяча";
                case 2 -> "две тысячи";
                case 3 -> "три тысячи";
                case 4 -> "четыре тысячи";
                case 5 -> "пять тысяч";
                case 6 -> "шесть тысяч";
                case 7 -> "семь тысяч";
                case 8 -> "восемь тысяч";
                case 9 -> "девять тысяч";
                default -> "";
            };
        }
        return word;
    }
}
