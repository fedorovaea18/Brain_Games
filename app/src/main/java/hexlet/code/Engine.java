package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static String getName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void generateQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static String getUserAnswer() {
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void showAnswer(boolean isCorrect, String userAnswer, String correctAnswer) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                    + "Correct answer was '" + correctAnswer + "'.");
        }
    }

    public static void messageCorrect() {
        System.out.println("Correct!");
    }

    public static void messageTryAgain(String name) {
        System.out.println("Let's try again, " + name + "!");
    }

    public static void messageCongratulations(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    public static int generateRandomNumber() {
        int minRandomNumber = 1;
        int maxRandomNumber = 100;
        return (int) (Math.random() * (maxRandomNumber - minRandomNumber + 1)) + minRandomNumber;
    }
}
