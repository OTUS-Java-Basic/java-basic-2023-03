package ru.otus.java.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
    private String text;
    private List<Answer> answers;

    public Question(String text) {
        this.text = text;
        this.answers = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}

class Answer {
    private String text;
    private boolean correct;

    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }
}

class Test {
    private List<Question> questions;
    private Scanner scanner;

    public Test() {
        this.questions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void run() {
        int correctCount = 0;
        int incorrectCount = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            System.out.println((i + 1) + ". " + question.getText());

            List<Answer> answers = question.getAnswers();
            for (int j = 0; j < answers.size(); j++) {
                Answer answer = answers.get(j);
                System.out.println((j + 1) + ") " + answer.getText());
            }

            System.out.print("Введите номер ответа: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer <= answers.size() && answers.get(userAnswer - 1).isCorrect()) {
                System.out.println("Правильно!");
                correctCount++;
            } else {
                System.out.println("Неправильно!");
                incorrectCount++;
            }
        }

        System.out.println("Количество правильных ответов: " + correctCount);
        System.out.println("Количество неправильных ответов: " + incorrectCount);
    }
    public static void main(String[] args) {
        Test test = new Test();

        Question question1 = new Question("Какой язык программирования используется для разработки Android приложений?");
        question1.addAnswer(new Answer("Java", true));
        question1.addAnswer(new Answer("Python", false));
        question1.addAnswer(new Answer("C++", false));
        question1.addAnswer(new Answer("JavaScript", false));

        Question question2 = new Question("Какой оператор используется для логического 'и' в Java?");
        question2.addAnswer(new Answer("&&", true));
        question2.addAnswer(new Answer("||", false));
        question2.addAnswer(new Answer("!", false));
        question2.addAnswer(new Answer("&", false));

        Question question3 = new Question("Что такое JDK в Java?");
        question3.addAnswer(new Answer("Java Development Kit", true));
        question3.addAnswer(new Answer("Java Debugging Kit", false));
        question3.addAnswer(new Answer("Java Deployment Kit", false));
        question3.addAnswer(new Answer("Java Documentation Kit", false));

        Question question4 = new Question("Какой метод вызывается автоматически при создании объекта в Java?");
        question4.addAnswer(new Answer("init", false));
        question4.addAnswer(new Answer("main", false));
        question4.addAnswer(new Answer("start", true));
        question4.addAnswer(new Answer("run", false));

        Question question5 = new Question("Что такое полиморфизм в Java?");
        question5.addAnswer(new Answer("Возможность объекта иметь несколько форм", true));
        question5.addAnswer(new Answer("Возможность объекта иметь несколько цветов", false));
        question5.addAnswer(new Answer("Возможность объекта иметь несколько размеров", false));
        question5.addAnswer(new Answer("Возможность объекта иметь несколько имен", false));

        test.addQuestion(question1);
        test.addQuestion(question2);
        test.addQuestion(question3);
        test.addQuestion(question4);
        test.addQuestion(question5);

        test.run();
    }
}