package ru.otus.java.homework;

import java.util.Scanner;

/**
 * Заготовка для выполнения ДЗ "Система тестирования".
 */
public class HomeworkTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вопросы и ответы
        String[] questions = {
                "Какой язык программирования используется для разработки Android приложений?",
                "Какой оператор используется для логического 'и' в Java?",
                "Что такое JDK в Java?",
                "Какой метод вызывается автоматически при создании объекта в Java?",
                "Что такое полиморфизм в Java?"
        };
        String[][] answers = {
                {"Java", "Python", "C++", "JavaScript"},
                {"&&", "||", "!", "&"},
                {"Java Development Kit", "Java Debugging Kit", "Java Deployment Kit", "Java Documentation Kit"},
                {"init", "main", "start", "run"},
                {"Возможность объекта иметь несколько форм", "Возможность объекта иметь несколько цветов", "Возможность объекта иметь несколько размеров", "Возможность объекта иметь несколько имен"}
        };
        int[] correctAnswers = {0, 0, 0, 3, 0}; // Индексы правильных ответов на каждый вопрос

        // Прохождение теста
        int correctCount = 0;
        int incorrectCount = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]); // Вывод вопроса
            for (int j = 0; j < answers[i].length; j++) {
                System.out.println((j + 1) + ") " + answers[i][j]); // Вывод вариантов ответов
            }
            System.out.print("Введите номер ответа: ");
            int userAnswer = scanner.nextInt(); // Чтение ответа пользователя
            if (userAnswer - 1 == correctAnswers[i]) { // Сравнение с правильным ответом
                System.out.println("Правильно!");
                correctCount++;
            } else {
                System.out.println("Неправильно!");
                incorrectCount++;
            }
        }

        // Вывод результатов
        System.out.println("Количество правильных ответов: " + correctCount);
        System.out.println("Количество неправильных ответов: " + incorrectCount);
    }
}
