package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int COUNT_ATTEMPTS = 3;
    public static final String WELCOME = "\nWelcome to the Brain Games!\nMay I have your name? ";
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 50;

    public static void run(String rules, String[][] questionsAndAnswers) {
        System.out.print(WELCOME);
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rules);

        for (int i = 0; i < COUNT_ATTEMPTS; i++) {
            String question = questionsAndAnswers[i][0];
            String correctAnswer = questionsAndAnswers[i][1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is the wrong answer ;(. "
                        + "The correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
