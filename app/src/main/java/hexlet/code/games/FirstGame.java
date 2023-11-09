package hexlet.code.games;

import hexlet.code.Engine;

public class FirstGame {
    public static final int ATTEMPTS_COUNT = 3;
    public static void play() {
        String userName = Engine.getName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswersCount = 0;

        while (correctAnswersCount < ATTEMPTS_COUNT) {
            int number = Engine.generateRandomNumber();
            Engine.generateQuestion(String.valueOf(number));
            String correctAnswer = number % 2 == 0 ? "yes" : "no";
            String userAnswer = Engine.getUserAnswer();

            if (userAnswer.equals(correctAnswer)) {
                Engine.messageCorrect();
                correctAnswersCount++;
            } else {
                Engine.showAnswer(false, userAnswer, correctAnswer);
                Engine.messageTryAgain(userName);
                return;
            }
        }
        Engine.messageCongratulations(userName);
    }
}
