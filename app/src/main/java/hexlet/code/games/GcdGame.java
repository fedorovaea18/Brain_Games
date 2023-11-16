package hexlet.code.games;

import hexlet.code.Engine;

public class GcdGame {
    public static void play() {
        String rules = "Find the greatest common divisor of given numbers.";
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(rules, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int numberFirst = Engine.generateRandomNumber();
            int numberSecond = Engine.generateRandomNumber();
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

