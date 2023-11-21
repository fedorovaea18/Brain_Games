package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GcdGame {
    public static final String RULES = "Find the greatest common divisor of given numbers.";
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 50;
    public static void play() {
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(RULES, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int numberFirst = Utils.generateRandomNumber(MIN_VALUE, MAX_VALUE);
            int numberSecond = Utils.generateRandomNumber(MIN_VALUE, MAX_VALUE);
            String question = numberFirst + " " + numberSecond;
            int gcd = findGcd(numberFirst, numberSecond);
            String correctAnswer = String.valueOf(gcd);
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }

    private static int findGcd(int numberFirst, int numberSecond) {
        while (numberSecond != 0) {
            int result = numberSecond;
            numberSecond = numberFirst % numberSecond;
            numberFirst = result;
        }
        return numberFirst;
    }
}

