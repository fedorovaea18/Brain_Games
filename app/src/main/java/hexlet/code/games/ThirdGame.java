package hexlet.code.games;

import hexlet.code.Engine;

public class ThirdGame {
    public static void play() {
        String userName = Engine.getName();
        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswersCount = 0;
        int attemptsCount = 3;

        while (correctAnswersCount < attemptsCount) {
            int numberFirst = Engine.generateRandomNumber();
            int numberSecond = Engine.generateRandomNumber();
            Engine.generateQuestion(numberFirst + " " + numberSecond);
            int correctAnswer = findGCD(numberFirst, numberSecond);
            String userAnswer = Engine.getUserAnswer();

            if (userAnswer.equals(String.valueOf(correctAnswer))) {
                Engine.messageCorrect();
                correctAnswersCount++;
            } else {
                Engine.showAnswer(false, userAnswer, String.valueOf(correctAnswer));
                Engine.messageTryAgain(userName);
                return;
            }
        }
        Engine.messageCongratulations(userName);
    }

    public static int findGCD(int numberFirst, int numberSecond) {
        while (numberSecond != 0) {
            int result = numberSecond;
            numberSecond = numberFirst % numberSecond;
            numberFirst = result;
        }
        return numberFirst;
    }
}
