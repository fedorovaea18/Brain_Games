package hexlet.code.games;

//import hexlet.code.Engine.Game;

import hexlet.code.Engine;

public class FirstGame implements Engine.Game {
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public String getQuestion() {
        int randomNumber = (int) (Math.random() * 10) + 1;
        return "Question: " + randomNumber;
    }

    public String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question.substring(10));
        return number % 2 == 0 ? "yes" : "no";
    }

    public boolean isCorrectAnswer(String question, String userAnswer) {
        int correctAnswer = Integer.parseInt(getCorrectAnswer(question));
        return userAnswer.equalsIgnoreCase(String.valueOf(correctAnswer));
    }
}
