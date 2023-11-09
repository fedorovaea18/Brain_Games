package hexlet.code.games;

import hexlet.code.Engine;

public class FifthGame {
    public static void play() {
        String userName = Engine.getName();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int correctAnswersCount = 0;
        int attemptsCount = 3;

        while (correctAnswersCount < attemptsCount) {
            int number = Engine.generateRandomNumber();
            Engine.generateQuestion(String.valueOf(number));
            String correctAnswer = isPrime(number) ? "yes" : "no";
            String userAnswer = Engine.getUserAnswer();

            if (userAnswer.equals(correctAnswer)) {
                Engine.messageCorrect();
                correctAnswersCount++;
            } else {
                Engine.showAnswer(false, userAnswer, correctAnswer);
                Engine.messageTryAgain(userName);
                return;
            }
        }
        Engine.messageCongratulations(userName);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
