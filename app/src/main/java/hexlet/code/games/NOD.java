package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
public class NOD {

    public static String getQuestion() {
        String questionText = "Find the greatest common divisor of given numbers.";
        return questionText;
    }

    public static int playRound(String namePlayer, int correctAnswerCount) {
        final int countRightAnswer = 3;
        Random randomOperand = new Random();
        final int rangeForNumber = 100;

        int numOne = randomOperand.nextInt(rangeForNumber);
        int numTwo = randomOperand.nextInt(rangeForNumber);

        String expression = "" + numOne + " " + numTwo;
        String rightAnswer = getRightAnswer(numOne, numTwo);
        String playerAnswer = Engine.askPlayerStringChoose(String.valueOf(expression));


        correctAnswerCount = Engine.checkAnswer(namePlayer, playerAnswer, rightAnswer, correctAnswerCount);
        Engine.gamePlay(namePlayer, correctAnswerCount);
        return correctAnswerCount;
    }

    public static String getRightAnswer(int a, int b) {
        if (b == 0) {
            return String.valueOf(a);
        }
        int temp = a % b;
        return getRightAnswer(b, temp);
    }
}
