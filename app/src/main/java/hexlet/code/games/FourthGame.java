package hexlet.code.games;

import hexlet.code.Engine;

public class FourthGame {
    public static final int ATTEMPTS_COUNT = 3;
    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 10;
    public static void play() {
        String userName = Engine.getName();
        System.out.println("What number is missing in the progression?");

        int correctAnswersCount = 0;

        while (correctAnswersCount < ATTEMPTS_COUNT) {
            int startNumber = Engine.generateRandomNumber();
            int progressionStep = Engine.generateRandomNumber();
            int progressionLength = generateRandomLength();
            int missingIndex = (int) (Math.random() * progressionLength);
            int missingNumber = startNumber + missingIndex * progressionStep;

            String question = generateQuestion(startNumber, progressionStep, progressionLength, missingIndex);
            Engine.generateQuestion(question);
            String userAnswer = Engine.getUserAnswer();

            if (userAnswer.equals(String.valueOf(missingNumber))) {
                Engine.messageCorrect();
                correctAnswersCount++;
            } else {
                Engine.showAnswer(false, userAnswer, String.valueOf(missingNumber));
                Engine.messageTryAgain(userName);
                return;
            }
        }
        Engine.messageCongratulations(userName);
    }

    public static String generateQuestion(int startNumber, int progressionStep,
                                          int progressionLength, int missingIndex) {
        String question = "";
        for (int i = 0; i < progressionLength; i++) {
            if (i == missingIndex) {
                question = question + ".." + " ";
            } else {
                question = question + (startNumber + i * progressionStep) + " ";
            }
        }
        return question;
    }

    public static int generateRandomLength() {
        return (int) (Math.random() * (MAX_LENGTH - MIN_LENGTH + 1)) + MIN_LENGTH;
    }
}
