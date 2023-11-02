package hexlet.code;

import java.util.Scanner;

public class Game {
    public static void isEven() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswerCount = 0;
        boolean result = false;

        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * 10) + 1;
            System.out.println("Question:" + randomNumber);
            System.out.print("Your answer: ");
            String getAnswer = scanner.next();

            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            if (getAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswerCount = correctAnswerCount + 1;
            } else {
                System.out.println("'" + getAnswer + "' is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (correctAnswerCount == 3) {
            System.out.println("Congratulations, " + userName + "!");
            result = true;
        }
    }
}
