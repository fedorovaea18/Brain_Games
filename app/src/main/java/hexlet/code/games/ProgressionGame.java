package hexlet.code.games;

import hexlet.code.Engine;

public class ProgressionGame {

    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 10;

    public static void play() {
        String rules = "What number is missing in the progression?";
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(rules, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int progressionLength = generateRandomLength();
            int startNumber = Engine.generateRandomNumber();
            int progressionStep = Engine.generateRandomNumber();
            int[] progression = generateProgression(startNumber, progressionStep, progressionLength);
            int missingIndex = (int) (Math.random() * progressionLength);
            int missingNumber = progression[missingIndex];
            String question = formatProgression(progression, missingIndex);
            String correctAnswer = String.valueOf(missingNumber);
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }

    private static int[] generateProgression(int startNumber, int progressionStep, int progressionLength) {
        int[] progression = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + i * progressionStep;
        }
        return progression;
    }

    private static String formatProgression(int[] progression, int missingIndex) {
        String[] viewProgression = new String[progression.length];
        for (int i = 0; i < progression.length; i++) {
            viewProgression[i] = (i == missingIndex) ? ".." : String.valueOf(progression[i]);
        }
        return String.join(" ", progression);
    }

    private static int generateRandomLength() {
        return MIN_LENGTH + (int) (Math.random() * (MAX_LENGTH - MIN_LENGTH + 1));
    }
}
