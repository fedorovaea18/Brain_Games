package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class ProgressionGame {
    public static final String RULES = "What number is missing in the progression?";
    public static final int FIRST_MIN_VALUE = 1;
    public static final int FIRST_MAX_VALUE = 50;

    public static final int STEP_MIN_VALUE = 1;
    public static final int STEP_MAX_VALUE = 10;
    public static final int PROGRESSION_MIN_VALUE = 5;
    public static final int PROGRESSION_MAX_VALUE = 10;

    public static void play() {
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(RULES, questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.COUNT_ATTEMPTS][2];
        for (int i = 0; i < Engine.COUNT_ATTEMPTS; i++) {
            int progressionLength = Utils.generateRandomNumber(PROGRESSION_MIN_VALUE, PROGRESSION_MAX_VALUE);
            int startNumber = Utils.generateRandomNumber(FIRST_MIN_VALUE, FIRST_MAX_VALUE);
            int progressionStep = Utils.generateRandomNumber(STEP_MIN_VALUE, STEP_MAX_VALUE);
            int[] progression = generateProgression(startNumber, progressionStep, progressionLength);
            int missingIndex = Utils.generateRandomNumber(0, progressionLength - 1);
            String[] fullProgression = new String[progression.length];
            for (int j = 0; j < progression.length; j++) {
                fullProgression[j] = String.valueOf(progression[j]);
            }
            String answer = fullProgression[missingIndex];
            questionsAndAnswers[i][1] = answer;
            fullProgression[missingIndex] = "..";
            String question = String.join(" ", fullProgression);
            questionsAndAnswers[i][0] = question;
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
}
