package hexlet.code.games;

import hexlet.code.Engine;

public class FourthGame implements Engine.Game {
    private int missingNumber;
    public String getRules() {
        return "What number is missing in the progression?";
    }

    public String getQuestion() {
        int lengthProgression = (int) (Math.random() * 5) + 5;
        int missingIndex = (int) (Math.random() * lengthProgression);
        int differenceProgression = (int) (Math.random() * 10) + 1;
        int firstNumber = (int) (Math.random() * 10) + 1;
        int firstNumberShift = (int) (Math.random() * 10);
        String progression = "";
        for (int i = 0; i < lengthProgression; i++) {
            if (i == missingIndex) {
                progression = progression + ".. ";
                missingNumber = firstNumber + (missingIndex * differenceProgression) + firstNumberShift;
            } else {
                progression = progression + (firstNumber + firstNumberShift + (i * differenceProgression)) + " ";
            }
        }
        return "Question: " + progression;
    }

    public String getCorrectAnswer(String question) {
        return String.valueOf(missingNumber);
    }

    public boolean checkCorrectAnswer(String question, String userAnswer) {
        String correctAnswer = getCorrectAnswer(question);
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
