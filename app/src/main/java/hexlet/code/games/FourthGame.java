package hexlet.code.games;

import hexlet.code.Engine;

public class FourthGame implements Engine.Game {
    private int missingNumber;
    public String getRules() {
        return "What number is missing in the progression?";
    }

    public String getQuestion() {
        int lengthProgression = (int) (Math.random() * 6) + 5;
        int missingIndex = (int) (Math.random() * lengthProgression);
        int differenceProgression = (int) (Math.random() * 10) + 1;
        String progression = "";
        for (int i = 0; i < lengthProgression; i++) {
            if (i == missingIndex) {
                progression = progression + ".. ";
                missingNumber = missingIndex * differenceProgression;
            } else {
                progression = progression + (i * differenceProgression) + " ";
            }
        }
        return "Question: " + progression;
    }

    public String getCorrectAnswer(String question) {
        return String.valueOf(missingNumber);
    }

    public boolean isCorrectAnswer(String question, String userAnswer) {
        int correctAnswer = Integer.parseInt(getCorrectAnswer(question));
        return userAnswer.equalsIgnoreCase(String.valueOf(correctAnswer));
    }
}
