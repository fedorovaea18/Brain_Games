package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 50;
    public static void play() {
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(RULES, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int number = Utils.generateRandomNumber(MIN_VALUE, MAX_VALUE);
            String question = String.valueOf(number);
            String correctAnswer = isEven(number) ? "yes" : "no";
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
