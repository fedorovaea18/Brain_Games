package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void runGame(Game game) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(game.getRules());

        int correctAnswerCount = 0;

        for (int i = 0; i < 3; i++) {
            String question = game.getQuestion();
            System.out.println("Question: " + question);

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (game.isCorrectAnswer(question, userAnswer)) {
                System.out.println("Correct!");
                correctAnswerCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(.\n"
                        + "Correct answer was '" + game.getCorrectAnswer(question) + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        if (correctAnswerCount == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    public interface Game {
        String getRules();
        String getQuestion();
        String getCorrectAnswer(String question);
        boolean isCorrectAnswer(String question, String userAnswer);
    }
}
