package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    public static final String RULES = "What is the result of the expression?";
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 50;

    public static final String[] MATH_OPERATORS = new String[] {"+", "-", "*"};
    public static void play() {
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(RULES, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int numberFirst = Utils.generateRandomNumber(MIN_VALUE, MAX_VALUE);
            int numberSecond = Utils.generateRandomNumber(MIN_VALUE, MAX_VALUE);
            int randomOperator = Utils.generateRandomNumber(0, MATH_OPERATORS.length - 1);
            String chosenOperator = MATH_OPERATORS[randomOperator];
            String question = numberFirst + " " + chosenOperator + " " + numberSecond;
            String correctAnswer = findExpression(chosenOperator, numberFirst, numberSecond);
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }

    private static String findExpression(String chosenOperator, int numberFirst, int numberSecond) {
        int result = 0;
        switch (chosenOperator) {
            case "+":
                result = numberFirst + numberSecond;
                break;
            case "-":
                result = numberFirst - numberSecond;
                break;
            case "*":
                result = numberFirst * numberSecond;
                break;
            default:
                throw new Error("Unknown operator: " + chosenOperator);
        }
        return String.valueOf(result);
    }
}
