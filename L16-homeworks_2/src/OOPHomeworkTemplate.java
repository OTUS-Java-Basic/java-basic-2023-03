/**
 * Заготовка для выполнения ДЗ "Система тестирования".
 */
class Question {
    String text;
    private final java.util.List<OOPHomeworkTemplate.Answer> answers;

    public Question(String text, java.util.List<OOPHomeworkTemplate.Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public void addData(OOPHomeworkTemplate.Answer answer) {
        answers.add(answer);
    }

    public java.util.List<OOPHomeworkTemplate.Answer> getAnswers() {
        return answers;
    }
}

public class OOPHomeworkTemplate {

    public static class Answer {
        private final String text;
        private final boolean isTrue;

        public Answer(String text, boolean isTrue) {
            this.text = text;
            this.isTrue = isTrue;
        }
    }

    private static void printQuestion(Question question) {
        System.out.println(question.text);
        for (OOPHomeworkTemplate.Answer answer : question.getAnswers()) {
            System.out.println(answer.text);
        }
    }

    public static void main(String[] args) {
        // Переменные для хранения количества правильных и неправильных ответов
        int correctCount = 0, wrongCount = 0;

        // Ниже вместо null надо написать реализацию,
        // написано так, чтобы просто компилировалось

        // TODO: Массив вопросов (вместо null надо написать определение массива)
        Question[] questions = {
                new Question("", java.util.List.of(
                        new Answer("", true),
                        new Answer("", false)
                ))
        };

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        // TODO: Цикл по всем вопросам - исправить, написать правильно
        for (int i = 0; i < 0; i++) {
            // TODO: Вывод вопроса на экран

            // TODO: Вывод вариантов ответов на экран

            System.out.print("Ваш ответ: ");
            //TODO: Считываем с консоли ответ пользователя

            //TODO: Проверяем ответ и выводим результат
            // а также увеличиваем счетчики правильных и неправильных ответов

            System.out.println();
        }

        //Выводим общий результат
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }
}
