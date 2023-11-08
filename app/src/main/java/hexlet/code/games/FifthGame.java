package hexlet.code.games;

import hexlet.code.Engine;

public class FifthGame implements Engine.Game {

    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public String getQuestion() {
        int randomNumber = (int) (Math.random() * 100) + 1;
        return "Question: " + randomNumber;
    }

    public String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question.substring(10));
        if (number <= 1) {
            return "no";
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return "no";
                }
            }
            return "yes";
        }
    }

    public boolean checkCorrectAnswer(String question, String userAnswer) {
        String correctAnswer = getCorrectAnswer(question);
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
