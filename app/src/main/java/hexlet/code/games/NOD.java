package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
public class NOD {
    public static void startGame(String namePlayer) {
        final int countRightAnswer = 3;
        String questionText = "Find the greatest common divisor of given numbers.";
        int correctAnswerCount = 0;
        Random randomOperand = new Random();
        Engine.showQuestionText(questionText);
        final int rangeForNumber = 100;

        do {
            int numOne = randomOperand.nextInt(rangeForNumber);
            int numTwo = randomOperand.nextInt(rangeForNumber);

            String expression = "" + numOne + " " + numTwo;
            String rightAnswer = getRightAnswer(numOne, numTwo);
            String playerAnswer = Engine.askPlayerStringChoose(String.valueOf(expression));

            correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);

        } while (correctAnswerCount >= 0 && correctAnswerCount < countRightAnswer);

        Engine.showResultGame((correctAnswerCount >= countRightAnswer), namePlayer);
    }

    public static String getRightAnswer(int a, int b) {
        if (b == 0) {
            return String.valueOf(a);
        }
        int temp = a % b;
        return getRightAnswer(b, temp);
    }
}
