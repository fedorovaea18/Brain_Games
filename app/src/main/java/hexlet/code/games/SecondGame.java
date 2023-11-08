package hexlet.code.games;

import hexlet.code.Engine;

public class SecondGame implements Engine.Game {
    private int result;
    public String getRules() {
        return "What is the result of the expression?";
    }

    public String getQuestion() {
        int randomNumberFirst = (int) (Math.random() * 100) + 1;
        int randomNumberSecond = (int) (Math.random() * 100) + 1;
        int randomOperationNumber = (int) (Math.random() * 2);
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
