package hexlet.code.games;

import hexlet.code.Engine;

public class FirstGame implements Engine.Game {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 100;

    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public String getQuestion() {
        int randomNumber = (int) (Math.random() * NUMBER_MAX) + NUMBER_MIN;
        return "Question: " + randomNumber;
    }

    public String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question.substring(10));
        return number % 2 == 0 ? "yes" : "no";
    }

    public boolean checkCorrectAnswer(String question, String userAnswer) {
        String correctAnswer = getCorrectAnswer(question);
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
