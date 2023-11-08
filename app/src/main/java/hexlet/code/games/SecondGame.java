package hexlet.code.games;

import hexlet.code.Engine;

public class SecondGame implements Engine.Game {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 100;
    private static final int OPERATION_COUNT = 3;
    private int result;
    public String getRules() {
        return "What is the result of the expression?";
    }

    public String getQuestion() {
        int randomNumberFirst = (int) (Math.random() * NUMBER_MAX) + NUMBER_MIN;
        int randomNumberSecond = (int) (Math.random() * NUMBER_MAX) + NUMBER_MIN;
        int randomOperationNumber = (int) (Math.random() * OPERATION_COUNT);
        String mathOperation = null;

        switch (randomOperationNumber) {
            case 0:
                mathOperation = "+";
                result = randomNumberFirst + randomNumberSecond;
                break;
            case 1:
                mathOperation = "-";
                result = randomNumberFirst - randomNumberSecond;
                break;
            case 2:
                mathOperation = "*";
                result = randomNumberFirst * randomNumberSecond;
                break;
            default:
                break;
        }
        return "Question: " + randomNumberFirst + " " + mathOperation + " " + randomNumberSecond;
    }
    public String getCorrectAnswer(String question) {
        return String.valueOf(result);
    }

    public boolean checkCorrectAnswer(String question, String userAnswer) {
        String correctAnswer = getCorrectAnswer(question);
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
