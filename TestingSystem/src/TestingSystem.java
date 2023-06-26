import java.util.Scanner;

public class TestingSystem {
    public static void main(String[] args) {
        String[] questions = {"В каком году началась Русско-Японская Война?", "В какой стране находится древний город Мачу-Пикчу?","Что обязательно нужно было использовать в этом задании?"};
        String[][] variants = {{"1905","1904","1908","1915"},{"Перу","Бразилия","Мексика", "Аргентина"}, {"Циклы","Массивы","ООП"}};
        boolean[][] rightAnswers = {{false,true,false,false},{true,false,false,false},{false,false,true}};
        boolean[] userAnswers = new boolean[questions.length];
        System.out.println("Здравствйте! Давайте пройдём небольшой тест.");
        for (int qNumber = 0; qNumber < questions.length; qNumber++) {
            Questions question = new Questions(qNumber,questions[qNumber],variants[qNumber], rightAnswers[qNumber]);
            question.printQuestion(qNumber);
            for (int i = 0; i < question.answers.length; i++) {
                question.answers[i].printAnswer(i);
            }
            System.out.println();
            Scanner input = new Scanner (System.in);
            String value;
            do {
                System.out.println("Введите номер варианта ответа:");
                value = input.nextLine();
            }
            while(!isNumeric(value) || Integer.parseInt(value) > variants[qNumber].length || Integer.parseInt(value) <= 0);
            userAnswers[qNumber]= question.isRight(value);
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
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

class Questions {
    String text;
    int number;
    Answers[] answers;
    public Questions (int number, String text, String[] variants, boolean[] isRight) {
        this.text = text;
        this.number = number;
        this.answers = new Answers[variants.length];
        for (int i = 0; i < variants.length; i++) {
            answers[i] = new Answers(i, variants[i],isRight[i]);
        }
    }
    public void printQuestion (int number) {
        System.out.println("Вопрос №"+(number+1)+":");
        System.out.println(text);
    }
    public boolean isRight(String userAnswer) {
        return answers[Integer.parseInt(userAnswer) - 1].isRight;

    }
}
class Answers {
    int number;
    String text;
    boolean isRight;
    public Answers (int number, String text, boolean isRight) {
        this.number = number;
        this.text = text;
        this.isRight = isRight;
    }
    public void printAnswer(int number) {
        System.out.print((number+1)+") "+text+"; ");
            }

}
