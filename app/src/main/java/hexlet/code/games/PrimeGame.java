package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeGame {
    public static void play() {
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(rules, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int number = Engine.generateRandomNumber();
            String question = String.valueOf(number);
            String correctAnswer = isPrime(number) ? "yes" : "no";
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        return questionsAndAnswers;
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
