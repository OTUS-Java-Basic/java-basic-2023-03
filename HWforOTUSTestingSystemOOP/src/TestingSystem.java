import java.util.Scanner;

public class TestingSystem {
    public static void main(String[] args) {
            Question[] questions = {                                                                                    //Создание массива объектов
                    new Question("В каком году началась Русско-Японская Война?", java.util.List.of(
                            new Answer("1905",false),
                            new Answer("1904",true),
                            new Answer("1908",false),
                            new Answer("1915",false))),
                    new Question("В какой стране находится древний город Мачу-Пикчу?", java.util.List.of(
                            new Answer("Перу",true),
                            new Answer("Бразилия",false),
                            new Answer("Мексика",false),
                            new Answer("Аргентина",false))),
                    new Question("Что обязательно нужно было использовать в этом задании?", java.util.List.of(
                            new Answer("Циклы",false),
                            new Answer("Массивы",false),
                            new Answer("ООП",true)))};
            boolean[] userAnswers = new boolean[questions.length];
            System.out.println("Здравствйте! Давайте пройдём небольшой тест.");
            for (int i = 0; i < questions.length; i++) {                                                                //Начало работы с пользователем
                System.out.println("Вопрос №"+(i+1)+") "+questions[i].getText());
                System.out.println("Варианты ответа:");
                for (int j =0; j < questions[i].answers.size(); j++) {
                    System.out.println((j+1)+") "+questions[i].getAnswers().get(j).text);
                }
                Scanner input = new Scanner(System.in);
                String value;
                do {
                    System.out.println("Введите номер варианта ответа:");
                    value = input.nextLine();
                }
                while(!isNumeric(value) || Integer.parseInt(value) > questions[i].answers.size() || Integer.parseInt(value) <= 0);
                userAnswers[i] = questions[i].getAnswers().get(Integer.parseInt(value)-1).isRight;
            }
            System.out.println("Ваш результат:");
            for (int i=0; i< userAnswers.length;i++) {
                if (userAnswers[i]) {
                    System.out.println((i+1)+") Верно");
                }
                else {
                    System.out.println((i+1)+") Неверно");
                }
            }

        }
    public static class Answer {
        private final String text;
        private final boolean isRight;
        public Answer(String text, boolean isRight) {
            this.text = text;
            this.isRight = isRight;
        }
    }
    public static class Question {
        private final String text;
        private final java.util.List<TestingSystem.Answer> answers;
        public Question(String text, java.util.List<TestingSystem.Answer> answers) {
            this.text = text;
            this.answers = answers;
        }
        public String getText() {
            return text;
        }
        public java.util.List<TestingSystem.Answer> getAnswers() {
            return answers;
        }
    }
    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
