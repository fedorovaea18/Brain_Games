package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame {
    public static void play() {
        String rules = "What is the result of the expression?";
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(rules, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int numberFirst = Engine.generateRandomNumber();
            int numberSecond = Engine.generateRandomNumber();
            char operator = generateRandomOperator();
            String question = numberFirst + " " + operator + " " + numberSecond;
            int result = findExpression(numberFirst, numberSecond, operator);
            String correctAnswer = String.valueOf(result);
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }

    private static char generateRandomOperator() {
        String mathOperator = "+-*";
        int randomIndex = (int) (Math.random() * mathOperator.length());
        return mathOperator.charAt(randomIndex);
    }

    private static int findExpression(int numberFirst, int numberSecond, char mathOperator) {
        switch (mathOperator) {
            case '+':
                return numberFirst + numberSecond;
            case '-':
                return numberFirst - numberSecond;
            case '*':
                return numberFirst * numberSecond;
            default:
                throw new Error("Unknown operator: " + mathOperator);
        }
    }
}
