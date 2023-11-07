package hexlet.code.games;

import hexlet.code.Engine;

public class ThirdGame implements Engine.Game {
    private int randomNumberFirst;
    private int randomNumberSecond;

    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    public String getQuestion() {
        randomNumberFirst = (int) (Math.random() * 100) + 1;
        randomNumberSecond = (int) (Math.random() * 100) + 1;
        return "Question: " + randomNumberFirst + " " + randomNumberSecond;
    }

    public String getCorrectAnswer(String question) {
        int maxNumber = Math.max(randomNumberFirst, randomNumberSecond);
        int minNumber = Math.min(randomNumberFirst, randomNumberSecond);
        int result;
        while (minNumber != 0) {
            result = minNumber;
            minNumber = maxNumber % minNumber;
            maxNumber = result;
        }
        return String.valueOf(maxNumber);
    }

    public boolean isCorrectAnswer(String question, String userAnswer) {
        int correctAnswer = Integer.parseInt(getCorrectAnswer(question));
        return userAnswer.equalsIgnoreCase(String.valueOf(correctAnswer));
    }
}
