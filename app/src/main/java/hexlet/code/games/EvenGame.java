package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    public static void play() {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(rules, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int number = Engine.generateRandomNumber();
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
