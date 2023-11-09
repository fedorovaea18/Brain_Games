package hexlet.code.games;

import hexlet.code.Engine;

public class SecondGame {
    public static final int ATTEMPTS_COUNT = 3;
    public static void play() {
        String userName = Engine.getName();
        System.out.println("What is the result of the expression?");

        int correctAnswersCount = 0;

        while (correctAnswersCount < ATTEMPTS_COUNT) {
            int numberFirst = Engine.generateRandomNumber();
            int numberSecond = Engine.generateRandomNumber();
            char operator = generateRandomOperator();
            String question = numberFirst + " " + operator + " " + numberSecond;
            Engine.generateQuestion(question);
            int correctAnswer = findExpression(numberFirst, numberSecond, operator);
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

    public static char generateRandomOperator() {
        String mathOperator = "+-*";
        int randomIndex = (int) (Math.random() * mathOperator.length());
        return mathOperator.charAt(randomIndex);
    }

    public static int findExpression(int numberFirst, int numberSecond, char mathOperator) {
        switch (mathOperator) {
            case '+':
                return numberFirst + numberSecond;
            case '-':
                return numberFirst - numberSecond;
            case '*':
                return numberFirst * numberSecond;
            default:
                break;
        }
        return numberFirst;
    }
}
